package com.padcmyanmar.mmhealthcare.data.VO

import com.google.gson.annotations.SerializedName

class AuthorVO {

    @SerializedName("author-id")
    var authorId:String?=null

    @SerializedName("author-name")
    var authorName:String?=null

    @SerializedName("author-picture")
    var authorImage:String?=null

}