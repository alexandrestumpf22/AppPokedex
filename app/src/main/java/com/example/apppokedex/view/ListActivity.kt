package com.example.apppokedex.view

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppokedex.R
import com.example.apppokedex.api.PokemonRepository
import com.example.apppokedex.domain.Pokemon
import com.example.apppokedex.domain.PokemonType
import com.example.apppokedex.viewmodel.PokemonViewModel
import com.example.apppokedex.viewmodel.PokemonViewModelFactory

class ListActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    var pokemons = emptyList<Pokemon?>()

    val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView = findViewById<RecyclerView>(R.id.rvPokemon)

        viewModel.pokemons.observe(this, Observer {
            loadedRecyclerView(it)
        })
    }

    private fun loadedRecyclerView(pokemons: List<Pokemon?>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}