package io.github.peepo3663.housecallprointerview.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.peepo3663.housecallprointerview.R
import io.github.peepo3663.housecallprointerview.models.User

class UserListAdapter(private val userList: MutableList<User>):
    RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {


    class UserListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.item_title)
        private val email = itemView.findViewById<TextView>(R.id.item_body)

        fun bind(user: User) {
            title.text = user.name
            email.text = user.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return UserListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val user = userList[position]

        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}