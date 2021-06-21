package com.shiqiliu.coroutineexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.utils.widget.MockView
import androidx.recyclerview.widget.RecyclerView
import com.shiqiliu.coroutineexample.R
import com.shiqiliu.coroutineexample.data.model.NowPlayingResult
import kotlinx.android.synthetic.main.row_movie_adapter.view.*

class MovieAdapter(var mContext : Context):RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    var mList :ArrayList<NowPlayingResult> = ArrayList()
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(movie:NowPlayingResult){
            itemView.text_view_name.text = movie.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    var view = LayoutInflater.from(mContext).inflate(R.layout.row_movie_adapter,parent,false)
    return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var movie = mList[position]
        return holder.bind(movie)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    fun setData(movieList:ArrayList<NowPlayingResult>){
        mList = movieList
        notifyDataSetChanged()
    }
}