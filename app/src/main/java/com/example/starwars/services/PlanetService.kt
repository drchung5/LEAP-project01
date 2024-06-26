package com.example.starwars.services

import com.example.starwars.StarWarsConstants.BASE_URL
import com.example.starwars.data.PlanetWrapper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PlanetService {

    @GET("planets")
    suspend fun getPlanets() : PlanetWrapper

    companion object {
        var planetService :PlanetService ?= null
        fun getInstance() :PlanetService {
            if( planetService == null ) {
                planetService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(PlanetService::class.java)
            }
            return planetService!!
        }
    }
}