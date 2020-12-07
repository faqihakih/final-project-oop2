package com.example.final_project_oop2_and_mobile.realm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.final_project_oop2_and_mobile.R

class UserDimasAdapter(val context: Context): RecyclerView.Adapter<UserDimasAdapter.UserDimasViewHolder>() {

    private val users: MutableList<UserDimas> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDimasViewHolder {
        return UserDimasViewHolder(LayoutInflater.from(context).inflate(R.layout.item_userdimas, parent, false))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserDimasViewHolder, position: Int) {
        holder.bindModel(users[position])
    }

    fun setUser(data: List<UserDimas>){
        users.clear()
        users.addAll(data)
        notifyDataSetChanged()
    }

    inner class UserDimasViewHolder(i: View): RecyclerView.ViewHolder(i){
        val tv2id : TextView = i.findViewById(R.id.tv2_id)
        val tv2provider : TextView = i.findViewById(R.id.tv2_provider)
        val tv2perusahaan : TextView = i.findViewById(R.id.tv2_perusahaan)
        fun bindModel(u: UserDimas){
            tv2id.text = u.getId().toString()
            tv2provider.text = u.getProvider()
            tv2perusahaan.text = u.getPerusahaan()
        }

    }



}