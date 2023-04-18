package com.example.upstox.feature.util

import android.view.View
import java.math.RoundingMode
import java.text.DecimalFormat

fun Double.roundOffDecimal(): Double {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.FLOOR
    return df.format(this).toDouble()
}

fun View.show() {
    this.visibility = View.VISIBLE

}

fun View.hide() {
    this.visibility = View.GONE
}