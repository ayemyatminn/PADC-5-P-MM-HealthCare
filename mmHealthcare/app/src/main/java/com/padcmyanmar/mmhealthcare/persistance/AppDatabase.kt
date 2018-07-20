package com.padcmyanmar.mmhealthcare.persistance

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.padcmyanmar.mmhealthcare.data.VO.HealthVO
import com.padcmyanmar.mmhealthcare.persistance.dao.HealthCareDao

@Database(entities = arrayOf(HealthVO::class),version = 1,exportSchema = false)

abstract class AppDatabase :RoomDatabase(){

    abstract fun healthCareInfoDao():HealthCareDao

    companion object {
        private val DB_NAME="HealthCare.DB"
        var INSTANCE:AppDatabase?=null
        fun getInstance(context: Context):AppDatabase{
            if (INSTANCE==null){
                INSTANCE= Room.databaseBuilder(context,AppDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()
            }
            var i= INSTANCE
            return i!!
        }
    }

}