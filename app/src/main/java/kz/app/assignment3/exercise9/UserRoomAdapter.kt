package kz.app.assignment3.exercise9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.app.assignment3.R
import kz.app.assignment3.models.UserRoom

class UserRoomAdapter(private var users: List<UserRoom>) : RecyclerView.Adapter<UserRoomAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.textViewName)
        val login: TextView = view.findViewById(R.id.textViewLogin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.name.text = user.name
        holder.login.text = user.login
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun updateUsers(newUsers: List<UserRoom>) {
        users = newUsers
        notifyDataSetChanged()
    }
}
