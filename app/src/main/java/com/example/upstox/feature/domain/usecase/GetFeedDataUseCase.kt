package com.example.upstox.feature.domain.usecase

import com.example.upstox.base.IBaseUseCase
import com.example.upstox.base.IResult
import com.example.upstox.feature.data.model.FeedModel
import com.example.upstox.feature.domain.repository.FeedDataRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class GetFeedDataUseCase @Inject constructor(private val repository: FeedDataRepository) :
    IBaseUseCase<String, FeedModel> {
    override suspend fun invoke(input: String): Flow<IResult<FeedModel>> {
        return repository.fetchFeedModel(input)
    }
}