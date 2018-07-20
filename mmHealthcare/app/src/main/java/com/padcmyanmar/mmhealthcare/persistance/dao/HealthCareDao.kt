package com.padcmyanmar.mmhealthcare.persistance.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.padcmyanmar.mmhealthcare.data.VO.HealthVO

@Dao
interface HealthCareDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(datalist: List<HealthVO>):LongArray

    @Query("select * from healthCare_Info")
    fun getAllData():LiveData<List<HealthVO>>

}