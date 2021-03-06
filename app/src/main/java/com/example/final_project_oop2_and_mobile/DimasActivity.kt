package com.example.final_project_oop2_and_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.final_project_oop2_and_mobile.realm.UserDimas
import com.example.final_project_oop2_and_mobile.realm.UserDimasAdapter
import io.realm.Realm
import io.realm.exceptions.RealmException
import kotlinx.android.synthetic.main.activity_dimas.*

class DimasActivity : AppCompatActivity() {
    lateinit var userDimasAdapter: UserDimasAdapter
    lateinit var realm: Realm
    var ln = LinearLayoutManager(this)

    fun initView(){
        rv_hasil.layoutManager = ln
        userDimasAdapter = UserDimasAdapter(this)
        rv_hasil.adapter = userDimasAdapter
        Realm.init(applicationContext)
        realm = Realm.getDefaultInstance()
        getAllUSer()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dimas)
        initView()
        action()

    }
    fun action(){
        btn_add.setOnClickListener {
            realm.beginTransaction()
            var count = 0

            realm.where(UserDimas::class.java).findAll().let {
                for(i in it){
                    count++
                }
            }
            try {
                var user = realm.createObject(UserDimas::class.java)
                user.setId(count+1)
                user.setProvider(et_provider.text.toString())
                user.setPerusahaan(et_perusahaan.text.toString())
                getAllUSer()

//                hasil.text = user.getId().toString() + " " + user.getProvider() + " " + user.getPerusahaan()
                et_provider.setText("")
                et_perusahaan.setText("")
                realm.commitTransaction()
            }catch (e: RealmException){

            }
        }

        btn_ubah.setOnClickListener(){
            realm.beginTransaction()
            realm.where(UserDimas::class.java).equalTo("id", et_id.text.toString().toInt()).findFirst().let {
                it!!.setProvider(et_provider.text.toString())
                it!!.setPerusahaan(et_perusahaan.text.toString())
            }
            realm.commitTransaction()
            getAllUSer()
        }

        btn_hapus.setOnClickListener(){
            realm.beginTransaction()
            realm.where(UserDimas::class.java).equalTo("id", et_id.text.toString().toInt()).findFirst().let {
                it!!.deleteFromRealm()
            }
            realm.commitTransaction()
            getAllUSer()
        }
    }
    fun getAllUSer(){
        realm.where(UserDimas::class.java).findAll().let {
            userDimasAdapter.setUser(it)
        }
    }


}