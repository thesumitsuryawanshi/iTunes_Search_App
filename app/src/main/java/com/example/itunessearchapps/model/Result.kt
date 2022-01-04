package com.example.itunessearchapps.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "MusicInfo_table")
data class Result(

    @PrimaryKey(autoGenerate = true)
    val MusicID: Int,
    var artistName: String,
    var trackPrice: Double,
    var trackName: String? = null,

    )