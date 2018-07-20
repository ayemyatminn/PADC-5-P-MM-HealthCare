package com.padcmyanmar.mmhealthcare.persistance.typeconverter

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.mmhealthcare.data.VO.AuthorVO

class AuthorTypeConverter {

    @TypeConverter
    fun toString(author:List<AuthorVO>): String{
        return Gson().toJson(author)
    }

    @TypeConverter
    fun toauthor(authorJson:String):List<AuthorVO>{
        val listType=object :TypeToken<List<AuthorVO>>(){}.type
        return Gson().fromJson(authorJson,listType)
    }

}