package com.android.smarthome

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {

    @GET("status")
    fun getStatus():Call<String>

    @GET("on")
    fun setOn():Call<String>

    @GET("off")
    fun setOff():Call<String>




}