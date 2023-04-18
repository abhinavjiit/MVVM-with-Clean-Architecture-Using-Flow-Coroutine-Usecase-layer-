package com.example.upstox.di

import com.example.upstox.feature.data.apiInterface.ApiInterface
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesOkHttp() = OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun providesRetrofit(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3/")
        .addConverterFactory(gsonConverterFactory)
        .client(client)
        .build()

    @Singleton
    @Provides
    fun gson(): Gson = GsonBuilder().setLenient().create()

    @Singleton
    @Provides
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Singleton
    @Provides
    fun providesSessionEndApiService(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)

}