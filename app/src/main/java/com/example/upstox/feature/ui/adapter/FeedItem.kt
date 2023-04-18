package com.example.upstox.feature.ui.adapter

import com.example.upstox.BR
import com.example.upstox.R
import com.example.upstox.base.IRecyclerItemViewModel
import com.example.upstox.feature.data.model.FeedListItem

sealed class FeedItem(private val layoutId: Int) : IRecyclerItemViewModel {

    override fun getLayoutId(): Int = layoutId

}


class FeedListItem(private val item: FeedListItem) : FeedItem(R.layout.item_feed) {
    override fun getBindingPairs(): List<Pair<Int, Any>> {

        return listOf(BR.item to item)
    }
}


