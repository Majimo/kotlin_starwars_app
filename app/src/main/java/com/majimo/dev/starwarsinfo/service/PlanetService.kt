package com.majimo.dev.starwarsinfo.service

import com.majimo.dev.starwarsinfo.repository.PlanetRepository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PlanetService {
    // val url: String = "https://swapi.co/api/"

    @GET("planets/{id}")
    fun retrieveRepositories(@Path("id") id: Int): Call<PlanetRepository>
}