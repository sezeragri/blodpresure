package com.bloodpressurechecker.bpblood.bptracker.screen

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BPTracker::class],version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun kisilerDao(): BPTrackerDao

    companion object{
        var INSTANCE: AppDatabase? = null

        fun veritabaniErisim(context: Context): AppDatabase?{
            if (INSTANCE == null){

                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "son.sqlite").createFromAsset("son.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}