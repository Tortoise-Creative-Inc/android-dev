package com.android.hea.api

import com.android.happilyeverapp.dataModels.roomDb.User
import retrofit2.Call
import retrofit2.http.*

interface Endpoints {

    @GET("user/{id}")
    fun getUser(@Path("id") id: Int): Call<User>

    @POST("/signup")
    fun signup(@Body newUser: User): Call<User>

    @POST("/login")
    fun login(@Body newUser: User): Call<User>

    @PUT("logout/{id}")
    fun logout(
        @Path("id") id: Int
    ): Call<User>
}