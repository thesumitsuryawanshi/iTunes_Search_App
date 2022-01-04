package com.example.itunessearchapps.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.itunessearchapps.model.MusicInfo
import com.example.itunessearchapps.model.Result


@Dao
interface MusicDAO {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMusicList(list: List<Result>)

    @Query("SELECT * FROM MusicInfo_table")
    suspend fun getAllMusicList(): List<Result>

}