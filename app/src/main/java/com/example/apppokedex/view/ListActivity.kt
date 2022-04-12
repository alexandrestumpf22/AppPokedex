package com.example.apppokedex.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apppokedex.R
import com.example.apppokedex.domain.Pokemon
import com.example.apppokedex.util.LoadingDialog
import com.example.apppokedex.viewmodel.PokemonViewModel
import com.example.apppokedex.viewmodel.PokemonViewModelFactory

class ListActivity : AppCompatActivity() {
    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.rvPokemon) }

    private val viewModel by lazy {
        ViewModelProvider(this@ListActivity, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val loading = LoadingDialog(this@ListActivity)
        loading.startLoading()

        viewModel.pokemons.observe(this@ListActivity, Observer {
            loadRecyclerView(it)
            loading.isDismiss()
        })
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {
        recyclerView.layoutManager = LinearLayoutManager(this@ListActivity)
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}