package com.example.photoapp.api

import com.example.photoapp.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET

interface PhotoAPI {

    @GET("?key=12973466-12130dc73adadafe7ca35b930&q=nature&image_type=photo")
    fun getPhoto(): Call<PhotoList>
}