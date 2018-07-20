package com.padcmyanmar.mmhealthcare.data.VO

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.mmhealthcare.persistance.typeconverter.AuthorTypeConverter

@Entity(tableName = "healthCare_Info")

class HealthVO {

    @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    var healthId:Int?=null

    @SerializedName("title")
    @ColumnInfo(name = "title")
    var healthTitle:String?=null

    @SerializedName("image")
    @ColumnInfo(name = "image")
    var healthImage:String?=null

    @SerializedName("author")
    @Embedded
    var author:AuthorVO?=null

    @SerializedName("short-description")
    @ColumnInfo(name = "short_description")
    var healthShortDescription:String?=null

    @SerializedName("published-date")
    @ColumnInfo(name = "published_date")
    var healthPublishDate:String?=null

    @SerializedName("complete-url")
    @ColumnInfo(name = "complete_url")
    var completeUrl:String?=null

}