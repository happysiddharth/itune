package com.example.basetemplate.data.remote

import com.example.basetemplate.data.model.ItuneResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    @GET(EndPoints.getAddress)
    fun getAddress(@Query("term") query: String):
            Observable<ItuneResponse>
}