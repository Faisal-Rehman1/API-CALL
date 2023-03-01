package com.MaximusTechnology.apicall.data.repository

import com.MaximusTechnology.apicall.data.model.CatFactResponse
import com.MaximusTechnology.apicall.data.remote.CatFactService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatFactRepository {
    private val service = Retrofit.Builder()
        .baseUrl("https://catfact.ninja/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CatFactService::class.java)

    suspend fun getCatFact(): CatFactResponse {
        return service.getCatFact()
    }
}