package com.example.segundaprova_jogos.database

import androidx.room.TypeConverter

class JogoConverters {

    @TypeConverter
    fun stringToMutableList(value: String ): MutableList<String> {

          val delim = ","
          val new_val =   value.split(delim).toMutableList()
        return  new_val
    }
    @TypeConverter
    fun fromString(value: MutableList<String>): String {
        return value.toString()
    }
}