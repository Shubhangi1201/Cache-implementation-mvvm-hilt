package com.example.cacheproject.feature.api

import com.example.cacheproject.feature.data.UserData
import retrofit2.http.GET

interface UserApi {

    companion object{
        const val base_url = "https://random-data-api.com/api/v2/"
    }

    @GET("users?size=20")
    suspend fun getUserDetails(): List<UserData>
}