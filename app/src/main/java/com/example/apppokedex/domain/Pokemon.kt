package com.example.apppokedex.domain

data class Pokemon (
    val number : Int,
    val name : String,
    val type : List<PokemonType>
) {
    @Suppress("DEPRECATION")
    val formattedName = name.capitalize()
    val formattedNumber = number.toString().padStart(3, '0')
    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/delail/$formattedNumber.png"
}