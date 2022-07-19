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






public class Player_copy : AppCompatActivity() {

   override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player)

       //var myWebView: WebView = findViewById(R.id.webview)
       //myWebView.webViewClient = WebViewClient()
       //myWebView.loadUrl(intent.getStringExtra("mname").toString())
       goWebBrowser(intent.getStringExtra("mname").toString())
        }

    fun goWebBrowser(str_url : String){
        var url = str_url
        if (url.startsWith("http://") || url.startsWith("https://")){
            url = url.trim() //TODO 불필요한 공백 제거
        }
        else {
            url = "http://"+url //TODO http 포함 실시
            url = url.trim() //TODO 불필요한 공백 제거
        }
        try {
            Log.d("---","---")
            Log.d("//===========//","================================================")
            Log.d("","\n"+"[A_Test_Kotlin > goWebBrowser() 메소드 : 외부 브라우저 링크 이동 실시]")
            Log.d("","\n"+"[주소 : "+url+"]")
            Log.d("//===========//","================================================")
            Log.d("---","---")
            val go = Intent(Intent.ACTION_VIEW,Uri.parse(url))
            go.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(go)
            overridePendingTransition(0, 0)
        }
        catch (e : Exception){
            e.printStackTrace()
        }
    }
}

/*class Player : YouTubeBaseActivity() {

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        initUI()

    }

    private fun initUI(){
        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                youTubePlayer: YouTubePlayer?,
                p2: Boolean
            ) {
                youTubePlayer?.loadVideo(intent.getStringExtra("mname").toString())
                youTubePlayer!!.cueVideo(getString(R.string.youtube_key))
            }
            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
Toast.makeText(applicationContext,"wrong",Toast.LENGTH_SHORT).show()
            }
        }
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