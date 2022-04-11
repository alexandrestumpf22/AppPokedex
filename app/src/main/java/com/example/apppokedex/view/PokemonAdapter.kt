package com.example.apppokedex.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apppokedex.R
import com.example.apppokedex.domain.Pokemon

class PokemonAdapter(
    private val items: List<Pokemon?>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item,parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        @SuppressLint("SetTextI18n")
        @Suppress("DEPRECATION")
        fun bindView(item: Pokemon?) = with(itemView){
            val ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
            val tvNumero = findViewById<TextView>(R.id.tvNumero)
            val tvNome = findViewById<TextView>(R.id.tvNome)
            val tvType1 = findViewById<TextView>(R.id.tvType1)
            val tvType2 = findViewById<TextView>(R.id.tvType2)

            //Glide é uma biblioteca de carregamento de imagem e faz a gestão do cach da imagem

            item?.let {
                Glide.with(itemView.context).load(it.imageUrl).into(ivPokemon)

                tvNumero.text = "Nº ${item.formattedNumber}"
                tvNome.text = item.formattedName
                tvType1.text = item.type[0].name.capitalize()

                if (item.type.size > 1) {
                    tvType2.visibility = View.VISIBLE
                    tvType2.text = item.type[1].name.capitalize()
                }
                else{
                    tvType2.visibility = View.GONE
                }
            }
        }
    }
}