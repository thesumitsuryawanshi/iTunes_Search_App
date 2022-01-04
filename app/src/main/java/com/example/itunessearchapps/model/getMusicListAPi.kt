package com.example.itunessearchapps.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface getMusicListApi {


    //https://itunes.apple.com/search?term=#search

    @GET("/search")
    fun getQueryList(
        @Query("term") query: String
    ): Call<MusicListData>

}