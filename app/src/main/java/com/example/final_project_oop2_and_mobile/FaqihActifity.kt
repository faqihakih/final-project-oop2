package com.example.final_project_oop2_and_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.final_project_oop2_and_mobile.realm.UserFaqih
import com.example.final_project_oop2_and_mobile.realm.UserFaqihAdapter
import io.realm.Realm
import io.realm.exceptions.RealmException
import kotlinx.android.synthetic.main.activity_faqih.*

class FaqihActifity : AppCompatActivity() {
    lateinit var userFaqihAdapter: UserFaqihAdapter
    var ln = LinearLayoutManager(this)


    lateinit var realm: Realm

    fun initView(){
        result.layoutManager = ln
        userFaqihAdapter = UserFaqihAdapter(this)
        result.adapter = userFaqihAdapter

        realm = Realm.getDefaultInstance()
        getAllUSer()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        action()
        setContentView(R.layout.activity_dimas)
    }
    fun action(){
        btn_add.setOnClickListener {
            realm.beginTransaction()
            var count = 0

            realm.where(UserFaqih::class.java).findAll().let {
                for(i in it){
                    count++
                }
            }
            try {
                var user = realm.createObject(UserFaqih::class.java)
                user.setId(count+1)
                user.setNama(et_nama.text.toString())
                user.setNIM(et_nim.text.toString())
                getAllUSer()

//                hasil.text = user.getId().toString() + " " + user.getProvider() + " " + user.getPerusahaan()
                et_nama.setText("")
                et_nim.setText("")
                realm.commitTransaction()
            }catch (e: RealmException){

            }
        }
    }
    fun getAllUSer(){
        realm.where(UserFaqih::class.java).findAll().let {
            userFaqihAdapter.setUser(it)
        }
    }


}