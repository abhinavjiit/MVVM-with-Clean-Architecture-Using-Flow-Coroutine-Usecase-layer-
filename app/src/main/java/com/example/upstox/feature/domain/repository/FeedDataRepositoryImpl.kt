package com.example.upstox.feature.domain.repository

import com.example.upstox.base.IResult
import com.example.upstox.base.performNetworkCall
import com.example.upstox.feature.data.apiInterface.ApiInterface
import com.example.upstox.feature.data.model.FeedModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@ViewModelScoped
class FeedDataRepositoryImpl @Inject constructor(private val apiInterface: ApiInterface) :
    FeedDataRepository {
    override suspend fun fetchFeedModel(endPoints: String): Flow<IResult<FeedModel>> {
        return performNetworkCall {
            apiInterface.fetchFeedList(endPoints)
        }
    }
}