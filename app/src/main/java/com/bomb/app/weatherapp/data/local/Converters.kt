package com.bomb.app.weatherapp.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun restoreList(listOfString: String?): List<String?>? =
        Gson().fromJson(listOfString, object : TypeToken<List<String?>?>() {}.type)

    @TypeConverter
    fun saveList(listOfString: List<String?>?): String? = Gson().toJson(listOfString)
}