package com.davevarga.flareon.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.davevarga.flareon.models.GenreString
import com.davevarga.flareon.models.Movie

@Database(entities = arrayOf(Movie::class, GenreString::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

}