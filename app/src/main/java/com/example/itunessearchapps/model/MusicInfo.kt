package com.example.itunessearchapps.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity
data class MusicInfo(
//    @PrimaryKey
//    val MusicInfoId: Int? = null,
    var artistName: String,
    var trackPrice: Double,
    var trackName: String? = null,
)
