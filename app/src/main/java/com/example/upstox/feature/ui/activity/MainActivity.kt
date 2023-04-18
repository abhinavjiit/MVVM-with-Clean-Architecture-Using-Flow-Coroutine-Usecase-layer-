package com.example.upstox.feature.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.upstox.R
import com.example.upstox.feature.ui.fragment.FeedFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, FeedFragment())
            .commit()

    }
}





//
//
////fun main() {
// Observable Pattern
////
////    val channel = YoutubeChannel()
////    User1(channel)
////    User2(channel)
////    User3(channel)
////    channel.addVideo()
////
////}
//
//class YoutubeChannel {
//
//    private val observes = mutableListOf<Observers>()
//
//    fun addObservers(observer: Observers) {
//        observes.add(observer)
//    }
//
//    fun addVideo() {
//        observes.forEach {
//            it.notifiy()
//        }
//    }
//
//
//}
//
//interface Observers {
//    var youtubeChannel: YoutubeChannel
//
//    fun notifiy()
//}
//
//
//class User1(override var youtubeChannel: YoutubeChannel) : Observers {
//
//    init {
//        youtubeChannel.addObservers(this)
//    }
//
//    override fun notifiy() {
//        println("USER1 Notified")
//    }
//
//}
//
//class User2(override var youtubeChannel: YoutubeChannel) : Observers {
//
//    init {
//        youtubeChannel.addObservers(this)
//    }
//
//    override fun notifiy() {
//        println("USER2 Notified")
//
//    }
//
//}
//
//class User3(override var youtubeChannel: YoutubeChannel) : Observers {
//
//    init {
//        youtubeChannel.addObservers(this)
//    }
//
//
//    override fun notifiy() {
//        println("USER3 Notified")
//
//    }
//
//}
//
//
////// handler looper, own intent service
//
//
//fun main() {
//
//    runBlocking {
//
//        repeat(2) { repeat ->
//
//            if (repeat == 1) {
//
//                DownloadManager.downloadFile(2500L) {
//
//                    println("first $repeat")
//                }
//            } else {
//                DownloadManager.downloadFile(1500L) {
//
//                    println("first $repeat")
//                }
//            }
//
//
//        }
//
//
//    }
//
//
//}
//
//
//object DownloadManager {
//
//
//    suspend fun downloadFile(delay: Long, result: (Boolean) -> Unit): Boolean {
//
//        withContext(IO) { delay(delay) }
//
//        result(true)
//
//        return true
//    }
//
//}
//
//
