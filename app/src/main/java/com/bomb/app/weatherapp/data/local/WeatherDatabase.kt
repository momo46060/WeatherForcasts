package com.bomb.app.weatherapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bomb.app.weatherapp.data.local.dao.CityDao
import com.bomb.app.weatherapp.data.local.dao.HistoricalDao
import com.bomb.app.weatherapp.data.local.entites.CityEntity
import com.bomb.app.weatherapp.data.local.entites.HistoricalEntity

@Database(entities = [CityEntity::class, HistoricalEntity::class], version = 4)
@TypeConverters(Converters::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun cityDao(): CityDao
    abstract fun historicalDao(): HistoricalDao
}