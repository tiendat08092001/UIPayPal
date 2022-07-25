package com.example.uipaypal.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.uipaypal.R
import com.example.uipaypal.datauser.User
import de.hdodenhof.circleimageview.CircleImageView


class UserViewAdapter(private val onClick: (User) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<User, UserViewAdapter.UserViewHolder>(
        FlowerDiffCallback
    ) {


    class UserViewHolder(itemView: View, val onClick: (User) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val userTextView: TextView = itemView.findViewById(R.id.user_textview)
        private val userImageView: CircleImageView = itemView.findViewById(R.id.img_user)
        private var currentUser: User? = null

        init {
            itemView.setOnClickListener {
                currentUser?.let {
                    onClick(it)
                }
            }
        }

        fun bind(user: User) {
            currentUser = user

            userTextView.text = user.name
            if (user.image != null) {
                userImageView.setImageResource(user.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_adapter, parent, false)
        return UserViewHolder(view, onClick)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }
}

object FlowerDiffCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }
}