package com.example.itunessearchapps

import android.app.Application
import com.example.itunessearchapps.model.getMusicListApi
import com.example.itunessearchapps.repository.repository
import com.example.itunessearchapps.roomdb.MusicDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MusicListApplication : Application() {

    lateinit var repository: repository

    override fun onCreate() {
        super.onCreate()

        initialize()
    }

    private fun initialize() {

        val getApi: getMusicListApi = Retrofit
            .Builder()
            .baseUrl("https://itunes.apple.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(getMusicListApi::class.java)

        val database = MusicDatabase.getDatabase(applicationContext)
        repository = repository(getApi, database,applicationContext)
    }

}