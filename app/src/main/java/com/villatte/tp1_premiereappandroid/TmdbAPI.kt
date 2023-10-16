package com.villatte.tp1_premiereappandroid

import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbAPI {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): Films

    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") api_key: String): Series

    @GET("trending/person/week")
    suspend fun lastperson(@Query("api_key") api_key: String): Personnes

    @GET("search/movie?")
    suspend fun moviesKeyWord(@Query("api_key") api_key: String, @Query("query") searchText: String): Films
}