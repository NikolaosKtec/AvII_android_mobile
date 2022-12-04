package com.example.segundaprova_jogos.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.segundaprova_jogos.R

import com.example.segundaprova_jogos.databinding.JogoInflaterBinding
import com.example.segundaprova_jogos.model.Jogo

class JogoRecyclerView: RecyclerView.Adapter<JogoViewHolder>() {
    var jogos:List<Jogo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogoViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.jogo_inflater, parent, false)
        val holder = JogoViewHolder(v)
        return holder
    }

    override fun onBindViewHolder(holder: JogoViewHolder, position: Int) {
        val jogo_escolhido = jogos.get(position)


        holder.titulo.text = jogo_escolhido.titulo
        holder.ano.text = jogo_escolhido.ano.toString()
        holder.plataforma.text = jogo_escolhido.plataforma.toString()
        holder.avaliacao.rating = jogo_escolhido.avaliacao.toFloat()
        holder.sinopse.text = jogo_escolhido.sinopse


    }

    override fun getItemCount(): Int {
        return jogos?.size ?: 0
    }
}

class JogoViewHolder(v:View) : RecyclerView.ViewHolder(v){
    val titulo:TextView = v.findViewById<TextView>(R.id.titulo)
    val ano:TextView = v.findViewById<TextView>(R.id.ano)
    val plataforma:TextView = v.findViewById<TextView>(R.id.plataforma)
    val avaliacao: RatingBar = v.findViewById<RatingBar>(R.id.ratingBar)
    val sinopse: TextView = v.findViewById<TextView>(R.id.sinopse)

//    init {
//
//    }
}