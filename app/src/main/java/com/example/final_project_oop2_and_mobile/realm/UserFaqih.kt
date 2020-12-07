package com.example.final_project_oop2_and_mobile.realm

import io.realm.RealmObject
import io.realm.annotations.RealmClass
@RealmClass
class UserFaqih {
    private var id:Int = 0
    private var nama: String = ""
    private var nim: String = ""
    private var email: String = ""
    private var alamat: String = ""

    fun setId(id:Int){
        this.id = id
    }

    fun getId(): Int {
        return id

    }
    fun setNama(provider:String){
        this.nama = provider
    }

    fun getNama(): String {
        return nama

    }
    fun setNIM(provider:String){
        this.nim = provider
    }

    fun getNIM(): String {
        return nim
    }
    fun setEmail(provider:String){
        this.email = provider
    }

    fun getEmail(): String {
        return email
    }
    fun setAlamat(provider:String){
        this.alamat = provider
    }

    fun getAlamat(): String {
        return alamat
    }
}