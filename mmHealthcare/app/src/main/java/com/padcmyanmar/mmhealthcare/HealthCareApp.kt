package com.padcmyanmar.mmhealthcare

import android.app.Application
import com.padcmyanmar.mmhealthcare.data.model.HealthModel

class HealthCareApp:Application() {

    companion object {
        const val TAG="HealthCareApp"
    }

    override fun onCreate() {
        super.onCreate()
        HealthModel.initHealthModel(applicationContext)
    }
}