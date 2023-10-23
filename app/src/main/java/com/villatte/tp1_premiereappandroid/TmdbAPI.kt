package com.villatte.tp1_premiereappandroid

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbAPI {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String, @Query("language") language: String): Films

    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") api_key: String, @Query("language") language: String): Series

    @GET("trending/person/week")
    suspend fun lastperson(@Query("api_key") api_key: String, @Query("language") language: String): Personnes

    @GET("search/movie?")
    suspend fun moviesKeyWord(@Query("api_key") api_key: String, @Query("query") searchText: String, @Query("language") language: String): Films

    @GET("search/tv?")
    suspend fun seriesKeyWord(@Query("api_key") api_key: String, @Query("query") searchText: String, @Query("language") language: String): Series

    @GET("search/person?")
    suspend fun personKeyWord(@Query("api_key") api_key: String, @Query("query") searchText: String, @Query("language") language: String): Personnes

    @GET("movie/{id}?append_to_response=credits")
    suspend fun moviesDetails(@Path("id") filmId: String, @Query("api_key") api_key: String, @Query("language") language: String): DetailsFilms

    @GET("tv/{id}?append_to_response=credits")
    suspend fun seriesDetails(@Path("id") tvId: String, @Query("api_key") api_key: String, @Query("language") language: String): DetailsSeries

}