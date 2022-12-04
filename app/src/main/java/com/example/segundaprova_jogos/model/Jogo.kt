package com.example.segundaprova_jogos.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Jogo (
    var titulo:String,
    var ano:Int,
    var plataforma:MutableList<String>,
    var avaliacao: Int,
    var sinopse: String,
//    var formato: List<String>
    )
{
    @PrimaryKey (autoGenerate = true)
    var id:Long = 0
}