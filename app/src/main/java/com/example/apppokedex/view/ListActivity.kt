package com.example.apppokedex.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppokedex.R
import com.example.apppokedex.domain.Pokemon
import com.example.apppokedex.domain.PokemonType

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyclerView = findViewById<RecyclerView>(R.id.rvPokemon)
        val charmander = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            4,
            "Charmander",
            listOf(PokemonType("Fire"))
        )
        val pokemons = listOf(
            charmander, charmander, charmander, charmander, charmander, charmander, charmander
        )
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}