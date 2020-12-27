package com.example.final_project_oop2_and_mobile.realm

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class UserFaqih: RealmObject() {
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

    fun setNama(nama:String){
        this.nama = nama
    }

    fun getNama(): String {
        return nama

    }

    fun setNim(nim:String){
        this.nim = nim
    }

    fun getNim(): String {
        return nim

    }
    fun setEmail(email:String){
        this.email = email
    }

    fun getEmail(): String {
        return email

    }
    fun setAlamat(alamat:String){
        this.alamat = alamat
    }

    fun getAlamat(): String {
        return alamat

    }
}