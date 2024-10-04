package com.bomb.app.weatherapp.data.utils

import com.bomb.app.weatherapp.utils.Resource
import retrofit2.Response

fun <T> Response<T>.toResource(): Resource<T> {
    if (this.isSuccessful) {
        this.body()?.let { result ->
            return Resource.Success(result)
        }
    }
    return Resource.Error(this.message())
}