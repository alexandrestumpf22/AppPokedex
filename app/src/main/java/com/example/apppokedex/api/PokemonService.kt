package com.example.apppokedex.api

import com.example.apppokedex.api.model.PokemonApiResult
import com.example.apppokedex.api.model.PokemonsApiResult
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon")
    fun listPokemons(@Query("limit")limit: Int): Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(@Path("number") number: Int): Call<PokemonApiResult>
}