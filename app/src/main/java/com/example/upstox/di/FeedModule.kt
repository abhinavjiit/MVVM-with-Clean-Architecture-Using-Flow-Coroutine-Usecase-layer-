package com.example.upstox.di

import com.example.upstox.feature.domain.repository.FeedDataRepository
import com.example.upstox.feature.domain.repository.FeedDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class FeedModule {

    @Binds
    abstract fun bindsFeedDataRepository(feedDataRepositoryImpl: FeedDataRepositoryImpl): FeedDataRepository


}