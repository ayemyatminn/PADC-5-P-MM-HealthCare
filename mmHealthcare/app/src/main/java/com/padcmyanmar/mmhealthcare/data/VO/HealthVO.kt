package com.padcmyanmar.mmhealthcare.data.VO

import com.google.gson.annotations.SerializedName

class HealthVO {

    @SerializedName("id")
    var healthId:String?=null

    @SerializedName("title")
    var healthTitle:String?=null

    @SerializedName("image")
    var healthImage:String?=null

    @SerializedName("author")
    var author:AuthorVO?=null

    @SerializedName("short-description")
    var healthShortDescription:String?=null

    @SerializedName("published-date")
    var healthPublishDate:String?=null

    @SerializedName("complete-url")
    var completeUrl:String?=null

}