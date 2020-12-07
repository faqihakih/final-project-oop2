package com.example.final_project_oop2_and_mobile.realm

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class UserDimas: RealmObject() {
    private var id:Int = 0
    private var provider: String = ""
    private var perusahaan: String = ""

    fun setId(id:Int){
        this.id = id
    }

    fun getId(): Int {
        return id

    }

    fun setProvider(provider:String){
        this.provider = provider
    }

    fun getProvider(): String {
        return provider

    }

    fun setPerusahaan(perusahaan:String){
        this.perusahaan = perusahaan
    }

    fun getPerusahaan(): String {
        return perusahaan

    }
}