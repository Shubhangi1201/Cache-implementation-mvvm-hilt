package com.example.cacheproject.feature.users

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cacheproject.feature.data.UserData
import com.example.cacheproject.databinding.SingleUserLayutBinding

class UserAdapter: ListAdapter<UserData, UserAdapter.myViewHolder>(userComparator()) {




    inner class myViewHolder(private val binding: SingleUserLayutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(users: UserData){
            binding.apply {
                Glide.with(itemView)
                    .load(users.avatar)
                    .into(avator)

                username.text = users.username
                email.text = users.email
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val binding =
            SingleUserLayutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return myViewHolder(binding)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
       val currentItem = getItem(position)

        if(currentItem != null){
            holder.bind(currentItem)
        }
    }


    class userComparator: DiffUtil.ItemCallback<UserData>(){
        override fun areItemsTheSame(oldItem: UserData, newItem: UserData) =
            oldItem.username == newItem.username

        override fun areContentsTheSame(oldItem: UserData, newItem: UserData) =
            oldItem == newItem


    }

}