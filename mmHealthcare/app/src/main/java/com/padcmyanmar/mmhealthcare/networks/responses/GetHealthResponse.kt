package com.padcmyanmar.mmhealthcare.networks.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.mmhealthcare.data.VO.HealthVO

class GetHealthResponse {

    @SerializedName("code")
    private val code:Int=0

    @SerializedName("message")
    private val message:String?=null

    @SerializedName("healthcare-info")
    private var healthList:List<HealthVO>?=null

    fun getCode():Int{
        return code;
    }

    fun getMessage():String?{
        return message;
    }

    fun getHealthList():List<HealthVO>{
        if (healthList==null){
            healthList=ArrayList<HealthVO>()
        }
        val healthListVal=healthList
        return healthListVal!!
    }

}