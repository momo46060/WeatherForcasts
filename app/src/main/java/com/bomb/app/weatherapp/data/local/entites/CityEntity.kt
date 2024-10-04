package com.bomb.app.weatherapp.data.local.entites

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.bomb.app.weatherapp.domain.model.City
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cities", indices = [Index(value = ["name", "country"], unique = true)])
data class CityEntity(
    @PrimaryKey(autoGenerate = true)
    var cityId: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("country")
    var country: String
)

fun CityEntity.toModel(): City = City(id = cityId, name =  name, country = country)

fun City.toEntity(): CityEntity = CityEntity(id, name, country)