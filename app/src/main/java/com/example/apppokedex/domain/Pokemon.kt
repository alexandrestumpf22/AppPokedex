package com.example.apppokedex.domain

import java.util.*

data class Pokemon (
    val number : Int,
    val name : String,
    val type : List<PokemonType>
) {
    val formattedName = name.replaceFirstChar { it.titlecase(Locale.getDefault()) }
    val formattedNumber = number.toString().padStart(3, '0')
    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"
}