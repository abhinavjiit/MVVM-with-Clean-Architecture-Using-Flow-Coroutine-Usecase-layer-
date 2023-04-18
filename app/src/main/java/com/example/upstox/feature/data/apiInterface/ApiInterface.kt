package com.example.upstox.feature.data.apiInterface

import android.hardware.usb.UsbEndpoint
import com.example.upstox.feature.data.model.FeedModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("{endPoint}")
    suspend fun fetchFeedList(@Path("endPoint") endpoint: String): Response<FeedModel>
}