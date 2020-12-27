package com.example.final_project_oop2_and_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.final_project_oop2_and_mobile.realm.UserFaqih
import com.example.final_project_oop2_and_mobile.realm.UserFaqihAdapter
import io.realm.Realm
import io.realm.exceptions.RealmException
import kotlinx.android.synthetic.main.activity_faqih.*

class FaqihActivity : AppCompatActivity() {
    lateinit var UserFaqihAdapter:UserFaqihAdapter
    lateinit var realm: Realm
    val lm = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faqih)
        initview()
        btn_add.setOnClickListener {
            realm.beginTransaction()
            var count = 0
            realm.where(UserFaqih::class.java).findAll().let {
                for (i in it){
                    count ++
                }
            }
            try {
                var user = realm.createObject(UserFaqih::class.java)
                user.setId(count+1)
                user.setNama(et_nama.text.toString())
                user.setNim(et_nim.text.toString())
                user.setEmail(et_nim.text.toString())
                user.setAlamat(et_nim.text.toString())
                et_nama.setText("")
                et_nim.setText("")
                et_email.setText("")
                et_alamat.setText("")
                realm.commitTransaction()
                getAllUser()
            }catch (e : RealmException){

            }
        }
        btn_update.setOnClickListener {
            realm.beginTransaction()
            realm.where(UserFaqih::class.java).equalTo("id", et_id.text.toString().toInt()).findFirst().let {
                it!!.setNama(et_nama.text.toString())
                it!!.setNim(et_nim.text.toString())
                it!!.setEmail(et_email.text.toString())
                it!!.setAlamat(et_alamat.text.toString())
            }
            realm.commitTransaction()
            getAllUser()
        }
        btn_delete.setOnClickListener {
            realm.beginTransaction()
            realm.where(UserFaqih::class.java).equalTo("id", et_id.text.toString().toInt()).findFirst().let {
                it!!.deleteFromRealm()
            }
            realm.commitTransaction()
            getAllUser()
        }
    }

    private fun initview(){
        rv_user.layoutManager = lm
        UserFaqihAdapter = UserFaqihAdapter(this)
        rv_user.adapter = UserFaqihAdapter
        Realm.init(applicationContext)
        realm = Realm.getDefaultInstance()
        getAllUser()
    }

    private fun getAllUser(){
        realm.where(UserFaqih::class.java).findAll().let{
            UserFaqihAdapter.setUser(it)
        }
    }
}