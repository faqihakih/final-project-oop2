package com.example.final_project_oop2_and_mobile.realm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project_oop2_and_mobile.R

class UserFaqihAdapter(val context: Context): RecyclerView.Adapter<UserFaqihAdapter.UserFaqihViewHolder>() {

    private val users: MutableList<UserFaqih> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserFaqihViewHolder {
        return UserFaqihViewHolder(LayoutInflater.from(context).inflate(R.layout.item_userfaqih, parent, false))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserFaqihViewHolder, position: Int) {
        holder.bindModel(users[position])
    }

    fun setUser(data: List<UserFaqih>){
        users.clear()
        users.addAll(data)
        notifyDataSetChanged()
    }

    inner class UserFaqihViewHolder(i: View): RecyclerView.ViewHolder(i){
        val tv2id : TextView = i.findViewById(R.id.tv2_id)
        val tv2nama : TextView = i.findViewById(R.id.tv2_nama)
        val tv2_nim : TextView = i.findViewById(R.id.tv2_nim)
        val tv2_email : TextView = i.findViewById(R.id.tv2_email)
        val tv2_alamat : TextView = i.findViewById(R.id.tv2_alamat)
        fun bindModel(u: UserFaqih){
            tv2id.text = u.getId().toString()
            tv2nama.text = u.getNama()
            tv2_nim.text = u.getNim()
            tv2_email.text = u.getEmail()
            tv2_alamat.text = u.getAlamat()
        }

    }

}