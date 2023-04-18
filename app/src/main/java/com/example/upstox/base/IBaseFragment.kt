package com.example.upstox.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class IBaseFragment<VB : ViewBinding, VM : ViewModel> : Fragment() {
    protected abstract val viewModel: VM

    lateinit var binding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater)
        setupView()
        setupObserver()
        return binding.root
    }

    abstract fun getViewBinding(inflater: LayoutInflater): VB

    protected abstract fun setupObserver()

    protected abstract fun setupView()

}