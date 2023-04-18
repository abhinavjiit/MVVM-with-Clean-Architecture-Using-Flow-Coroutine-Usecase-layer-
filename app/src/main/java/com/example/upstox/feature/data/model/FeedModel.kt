package com.example.upstox.feature.data.model

import com.google.gson.annotations.SerializedName

data class FeedModel(
    @SerializedName("data")
    val data: List<FeedListItem> = emptyList()
)


data class FeedListItem(

    @SerializedName("avg_price")
    val avgPrice: String = "",
    @SerializedName("quantity")
    val quantity: Double = 0.0,
    @SerializedName("symbol")
    val symbol: String = "",
    @SerializedName("ltp")
    val ltp: Double = 0.0,
    @SerializedName("close")
    val close: Double = 0.0,
    var pnl: Double = 0.0

)

data class FieldData(
    var currentValue: Double = 0.0,
    var investedValue: Double = 0.0,
    var todayPL: Double = 0.0,
    var finalPL: Double = 0.0



)
