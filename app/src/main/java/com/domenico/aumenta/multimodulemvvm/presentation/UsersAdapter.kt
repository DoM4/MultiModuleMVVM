package com.domenico.aumenta.multimodulemvvm.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.domenico.aumenta.core.utils.CircleTransform
import com.domenico.aumenta.multimodulemvvm.R
import com.domenico.aumenta.multimodulemvvm.databinding.ItemUserBinding
import com.domenico.aumenta.multimodulemvvm.model.User
import com.squareup.picasso.Picasso


/**
 * Created by domenicoaumenta on 2020-07-15.
 */

class UsersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var users = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as UserViewHolder).bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    internal inner class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.userName.text = user.displayName
            binding.userReputationLabel.text =
                binding.root.context.getString(R.string.user_reputation, user.reputation)
            Picasso.get()
                .load(user.profileImage)
                .transform(CircleTransform())
                .into(binding.userThumbnail)

            binding.userContainer.setOnClickListener {
                TODO()
            }
        }

    }
}
