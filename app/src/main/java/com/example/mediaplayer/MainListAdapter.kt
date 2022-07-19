package com.example.mediaplayer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import android.content.Intent
import android.widget.Toast
import com.bumptech.glide.load.engine.DiskCacheStrategy


class MainListAdapter (private val context: Context) : RecyclerView.Adapter<MainListAdapter.ViewHolder>() {
    var mCallback : ((String) -> Unit?)? =null
    var datas = mutableListOf<Media_Data_Detail>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.media_list,parent,false)
        return ViewHolder(view)
    }
    interface OnItemClickListener{
        fun onItemClick(v:View, data: Media_Data_Detail, pos : Int)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
        holder.itemView.setOnClickListener {
            val intent: Intent //인텐트 선언
            intent = Intent(context, Player::class.java) //look_memo.class부분에 원하는 화면 연결
            intent.putExtra("mname", datas[position].url.toString()) //변수값 인텐트로 넘기기
            context.startActivity(intent) //액티비티 열기
        }

    }

    fun setCallback(callback:(String)->Unit){
        mCallback = callback
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txtTitle: TextView = itemView.findViewById(R.id.Title)
        private val txtSub: TextView = itemView.findViewById(R.id.Sub)
        private val imgThumbnail: ImageView = itemView.findViewById(R.id.Thumnail)
        private val Url : TextView = itemView.findViewById(R.id.url)


        fun bind(item: Media_Data_Detail) {
            txtTitle.text = item.title
            txtSub.text = item.sub
            Url.text = item.url
            Glide.with(context)
                .load(item.thumbnail).skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE).error(R.drawable.ic_launcher_foreground).into(imgThumbnail)
            itemView.setOnClickListener {
                mCallback?.invoke(item.url)
            }

        }

    }
}