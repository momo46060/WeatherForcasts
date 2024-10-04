package com.bomb.app.weatherapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.bomb.app.weatherapp.data.local.WeatherDatabase
import com.bomb.app.weatherapp.data.local.dao.CityDao
import com.bomb.app.weatherapp.data.local.dao.HistoricalDao
import com.bomb.app.weatherapp.data.remote.WeatherAPIService
import com.bomb.app.weatherapp.data.repository.WeatherRepositoryImpl
import com.bomb.app.weatherapp.domain.repository.WeatherRepository
import com.bomb.app.weatherapp.domain.usecase.city.AddCityUseCase
import com.bomb.app.weatherapp.domain.usecase.city.GetCitiesUseCase
import com.bomb.app.weatherapp.domain.usecase.historical.GetHistoricalDataUseCase
import com.bomb.app.weatherapp.presentation.viewmodel.WeatherViewModel
import net.sqlcipher.database.SupportFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {


    // Use Cases
    single { AddCityUseCase(get()) }
    single { GetCitiesUseCase(get()) }
    single { GetHistoricalDataUseCase(get()) }

    // Repository
    single<WeatherRepository> { WeatherRepositoryImpl(get(), get(),get()) }

    // Database
    single { provideWeatherDatabase(get()) }
    single { provideCityDao(get()) }
    single { provideHistoricalDao(get()) }

    // API Service
    single { provideRetrofit().create(WeatherAPIService::class.java) }

    // ViewModel
    viewModel { WeatherViewModel(get(), get(), get()) }
}

// Retrofit and OkHttp
fun provideRetrofit(): Retrofit = Retrofit.Builder()
    .baseUrl("https://api.openweathermap.org/data/2.5/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(provideOkHttpClient())
    .build()

fun provideOkHttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    return OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
}


// DAOs
fun provideCityDao(db: WeatherDatabase): CityDao = db.cityDao()
fun provideHistoricalDao(db: WeatherDatabase): HistoricalDao = db.historicalDao()

fun provideWeatherDatabase(context: Context): WeatherDatabase =
    databaseBuilder(
        context.applicationContext,
        WeatherDatabase::class.java,
        "WeatherDatabase"
    ).fallbackToDestructiveMigration()
        .build()
