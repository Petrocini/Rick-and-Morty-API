package com.petrocini.rickandmorty.data.network.service

import com.petrocini.rickandmorty.data.network.dto.PageInfoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/character/")
    suspend fun getAllCharacters(@Query("page") page: Int): Response<PageInfoDto>

    companion object {
        const val BASE_API_URL = "https://rickandmortyapi.com/"
    }

}