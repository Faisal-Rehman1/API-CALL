package com.MaximusTechnology.apicall.data.remote

import com.MaximusTechnology.apicall.data.model.CatFactResponse
import retrofit2.http.GET

interface CatFactService {
    @GET("fact")
    suspend fun getCatFact(): CatFactResponse
}