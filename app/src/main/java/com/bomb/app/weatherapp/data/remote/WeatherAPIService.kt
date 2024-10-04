package com.bomb.app.weatherapp.data.remote

import com.bomb.app.weatherapp.data.remote.response.HistoricalResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPIService {

    @GET("forecast")
    suspend fun getHistoricalData(@Query("q") query: String,
                                  @Query("appid") apiKey: String="61c94e6468c0245a94e258e435323aa9"): Response<HistoricalResponse>
}