package com.example.itunessearchapps.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.itunessearchapps.model.Result
import com.example.itunessearchapps.model.getMusicListApi
import com.example.itunessearchapps.roomdb.MusicDatabase
import retrofit2.await

class repository(
    val api: getMusicListApi,
    val database: MusicDatabase,
    private val context: Context
) {


    private val mutableLivedata = MutableLiveData<List<Result>>()

    val musicList: LiveData<List<Result>>
        get() = mutableLivedata

    suspend fun getMusicList(searchKeyword: String) {


        Log.d("testing ", "fetched data from api list = ${musicList} ")

        val musicList = api.getQueryList(searchKeyword).await().results
        database.dao().insertMusicList(musicList)
        mutableLivedata.postValue(musicList)
    }


    suspend fun getListfromDatabase() {
        val __list = database.dao().getAllMusicList()
        val temp = Result(11111, "teamp", 1.11111, "temp")
        mutableLivedata.postValue(listOf(temp))
        mutableLivedata.postValue(__list)

    }
}