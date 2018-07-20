package com.padcmyanmar.mmhealthcare.mvp.View

import android.arch.lifecycle.MutableLiveData
import com.padcmyanmar.mmhealthcare.data.VO.HealthVO

interface HealthView :BaseView{

    fun displayHealthList(healthList:List<HealthVO>)
    fun displayError(message:String)
    fun displayUrl(url:String)
}