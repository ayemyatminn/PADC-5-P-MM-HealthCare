package com.padcmyanmar.mmhealthcare.data.VO

import android.arch.persistence.room.ColumnInfo
import com.google.gson.annotations.SerializedName

class AuthorVO {

    @SerializedName("author-id")
    @ColumnInfo(name = "author-id")
    var authorId:String?=null

    @SerializedName("author-name")
    @ColumnInfo(name = "author-name")
    var authorName:String?=null

    @SerializedName("author-picture")
    @ColumnInfo(name = "author-profile")
    var authorImage:String?=null

}