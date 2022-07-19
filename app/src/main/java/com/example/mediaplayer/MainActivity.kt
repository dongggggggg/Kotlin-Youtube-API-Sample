package com.example.mediaplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var mainListAdapter: MainListAdapter
    val datas = mutableListOf<Media_Data_Detail>()
    var list: RecyclerView? = null
    private lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById(R.id.mainListView)
        initRecycler()
    }

    private fun initRecycler() {
        mainListAdapter = MainListAdapter(this)
        datas.apply {
            add(Media_Data_Detail("노래 1", "추적추적 비오는 날, 카페에서 작업하며 듣기좋은 Nora Jonse의 best jazzpop", "https://i.ytimg.com/vi/rkbYMP6xGJk/hqdefault.jpg?sqp=-oaymwEcCPYBEIoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCAH45Sm8LPBPW33Iis5NP3MHKmdg","rkbYMP6xGJk"))
            add(Media_Data_Detail("노래 2", "여름 냄새 가득한 음악이 흘러나오던 제주의 어느 호텔 앞에서", "https://i.ytimg.com/vi/Zof6hhWkCU0/hqdefault.jpg?sqp=-oaymwEcCPYBEIoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLD3-zkXCrem49L_j_RCRk-2Fxfd4Q","Zof6hhWkCU0"))
            add(Media_Data_Detail("노래 3", "조용히 혼자 있고 싶을 때 듣는 감성음악, 조용한팝송, 광고없는팝송", "https://i.ytimg.com/vi/G1JQd78ZJ2I/hqdefault_live.jpg?sqp=-oaymwEcCPYBEIoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDk7YH6wljOpS5R4iBvRV1N3pzJ5g","G1JQd78ZJ2I"))
        }

            mainListAdapter.datas = datas
            list?.adapter = mainListAdapter

            Log.d("태그2", "내용 : " + datas)
            mainListAdapter.notifyDataSetChanged()
    }
    /* mainListAdapter.setCallback {
         Intent(
         this@MainActivity,Player::class.java
     ).apply {
         putExtra("data",data)
         addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
     }.run { startActivity(this) } }*/
}