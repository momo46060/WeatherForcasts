package com.bomb.app.weatherapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bomb.app.weatherapp.data.local.entites.CityEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cityEntity: CityEntity)


    @Query("SELECT * FROM cities")
    fun getCities(): Flow<List<CityEntity>>
}