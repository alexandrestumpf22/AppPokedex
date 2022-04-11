package com.example.apppokedex.api

import android.util.Log
import com.example.apppokedex.api.model.PokemonApiResult
import com.example.apppokedex.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {
    private val service: PokemonService = TODO()

    fun listPokemons(limit: Int = 151): PokemonsApiResult? {
        val call = service.listPokemons(limit)

        return call.execute().body()
    }

    fun getPokemon(number: Int): PokemonApiResult?{
        val call = service.getPokemon(number)

        //tem uma execução sincrona
        return call.execute().body()

        //tem uma execução assincrona
//        call.enqueue(object : Callback<PokemonsApiResult>{
//            override fun onFailure(call: Call<PokemonsApiResult>, t: Throwable) {
//                Log.e("POKEMON_API", "Erro ao carregar a lista de Pokemon. ", t)
//            }
//
//            override fun onResponse(
//                call: Call<PokemonsApiResult>,
//                response: Response<PokemonsApiResult>
//            ) {
//                if (response.isSuccessful){
//                    val body = response.body()
//                    body?.results?.let {
//                        Log.d("POKEMON_API", it[0].name)
//                    }
//                }
//                Log.d("POKEMON_API", "Lista de Pokemon carregada.")
//            }
//        })
    }
}