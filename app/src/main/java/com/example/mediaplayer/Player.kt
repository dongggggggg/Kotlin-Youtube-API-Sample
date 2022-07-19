package com.example.mediaplayer

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.VideoView
import android.net.Uri
import android.os.Build
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.MediaController
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView






public class Player : YouTubeBaseActivity() {

   override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player)
       var youtubePlayerInit = findViewById<YouTubePlayerView>(R.id.videoView)
       Log.d("유튜브1",intent.getStringExtra("mname").toString()+getString(R.string.youtube_key))
       initUI(youtubePlayerInit,intent.getStringExtra("mname").toString())
        }
    private fun initUI(view : YouTubePlayerView,url:String){
        view.initialize("develop",object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                youTubePlayer: YouTubePlayer?,
                wasRestored: Boolean
            ) {
                if(!wasRestored){
                    youTubePlayer!!.cueVideo(url)
                }
                youTubePlayer?.setPlayerStateChangeListener(object :
                    YouTubePlayer.PlayerStateChangeListener{
                    override fun onAdStarted() {
                    }

                    override fun onLoading() {
                    }

                    override fun onVideoStarted() {
                    }

                    override fun onVideoEnded() {
                    }

                    override fun onError(p0: YouTubePlayer.ErrorReason?) {
                    }

                    override fun onLoaded(p0: String?) {
                        youTubePlayer.play()
                    }
                })
            }
            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(applicationContext,"wrong",Toast.LENGTH_SHORT).show()
            }
        })
    }

}

/*class Player : YouTubeBaseActivity() {

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        initUI()

    }



}
//        val youtube_view : YouTubePlayerView
//        youtube_view = findViewById(R.id.youtube_view)
//        youtube_view.initialize(getString(R.string.youtube_key),this)
////        Log.d("태그3", "내용 : " + mgetdata.getStringExtra("mname").toString())
//    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayer: YouTubePlayer?, isReady: Boolean) {
//        if (!isReady) {
//            var mgetdata = intent
//            val playKey = mgetdata.getStringExtra("mname")
//            Log.d("태그3", "내용 : " + mgetdata.getStringExtra("mname").toString())
//            youtubePlayer!!.cueVideo(playKey)
//        }
//    }*/