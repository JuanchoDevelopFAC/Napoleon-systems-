package com.example.napoleonsystemsapp.home.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.napoleonsystemsapp.R
import com.example.napoleonsystemsapp.home.data.PostModel
import kotlinx.android.synthetic.main.home_rv_item_view.view.*

class HomeAdapter(private var listener: HomeListener): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var data : ArrayList<PostModel>?=null

    interface HomeListener {
        fun onItemDeleted(postModel: PostModel, position: Int)
    }

    fun setData(list: ArrayList<PostModel>){
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_rv_item_view, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
        holder.itemView.img_delete.setOnClickListener {
            item?.let { it1 ->
                listener.onItemDeleted(it1, position)
            }
        }
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: PostModel?) {
            itemView.tv_home_item_title.text = item?.title
            itemView.tv_home_item_body.text = item?.body

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, Detail::class.java)
                intent.putExtra("INTENT_TITLE", itemView.tv_home_item_title.text.toString())
                intent.putExtra("INTENT_BODY", itemView.tv_home_item_body.text.toString())
                startActivity(itemView.context, intent, Bundle())
            }
        }
    }

    fun addData(postModel: PostModel) {
        data?.add(0, postModel)
        notifyItemInserted(0)
    }

    fun removeData(position: Int) {
        data?.removeAt(position)
        notifyDataSetChanged()
    }

}