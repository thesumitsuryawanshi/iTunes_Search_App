package com.example.itunessearchapps.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.itunessearchapps.model.MusicInfo
import com.example.itunessearchapps.model.Result


@Database(entities = [Result::class], version = 1)
abstract class MusicDatabase : RoomDatabase() {

    abstract fun dao(): MusicDAO


    companion object {
        @Volatile
        private var INSTANCE: MusicDatabase? = null

        fun getDatabase(context: Context): MusicDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        MusicDatabase::class.java,
                        "MusicListDB"
                    ).build()
                }
            }
            return INSTANCE!!
        }

    }
}