package com.example.upstox.feature.ui.fragment

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.upstox.BR
import com.example.upstox.base.IBaseFragment
import com.example.upstox.base.IResult
import com.example.upstox.databinding.FragmentFeedBinding
import com.example.upstox.feature.data.model.FieldData
import com.example.upstox.feature.domain.viewmodel.FeedViewModel
import com.example.upstox.feature.ui.adapter.FeedListItem
import com.example.upstox.feature.ui.adapter.FeedRecyclerAdapter
import com.example.upstox.feature.util.hide
import com.example.upstox.feature.util.roundOffDecimal
import com.example.upstox.feature.util.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FeedFragment : IBaseFragment<FragmentFeedBinding, FeedViewModel>() {

    override val viewModel: FeedViewModel by viewModels()
    private val _endPoint = "6d0ad460-f600-47a7-b973-4a779ebbaeaf"
    private val adapter by lazy { FeedRecyclerAdapter() }


    override fun getViewBinding(inflater: LayoutInflater): FragmentFeedBinding {
        return FragmentFeedBinding.inflate(inflater)
    }

    override fun setupView() {
        binding.rvFeedItem.adapter = adapter
        viewModel.fetchFeedList(_endPoint)
    }

    override fun setupObserver() {
        viewModel.feedData.observe(viewLifecycleOwner) {
            when (it) {
                is IResult.Loading -> {
                    binding.loader.show()
                }
                is IResult.Error -> {

                }
                is IResult.Success -> {
                    binding.loader.hide()
                    binding.bottomView.show()
                    it.data?.data?.forEach {
                        adapter.addItem(FeedListItem(it))
                    }
                }
                else -> {}
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED)
            {
                viewModel.feedBottomData.collect {
                    binding.setVariable(BR.fieldData, it)
                    binding.executePendingBindings()
                }
            }

        }

    }

}