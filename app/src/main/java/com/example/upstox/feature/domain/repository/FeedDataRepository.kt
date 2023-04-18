package com.example.upstox.feature.domain.repository

import com.example.upstox.base.IResult
import com.example.upstox.feature.data.model.FeedModel
import kotlinx.coroutines.flow.Flow


interface FeedDataRepository {
    suspend fun fetchFeedModel(endPoints: String): Flow<IResult<FeedModel>>
}