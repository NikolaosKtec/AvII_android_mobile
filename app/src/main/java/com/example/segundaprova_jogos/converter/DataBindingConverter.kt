package com.example.segundaprova_jogos.converter

import androidx.databinding.InverseMethod

class DataBindingConverter {
companion object {
    @JvmStatic
    fun from_list_toString(list: List<String>?): String? {
        return list.toString()
    }

    @JvmStatic
    @InverseMethod("from_list_toString")
    fun str_to_list(value: String?):List<String>? {
        return  listOf<String>()
    }

    @JvmStatic
    fun to_float(value: Int): Float? {
        return value.toFloat()
    }

    @JvmStatic
    @InverseMethod("to_float")
    fun to_int(value: Float):Int? {
        return value.toInt()
    }

    @JvmStatic
    fun int_to_str(value:Int):String? {
        return value.toString()
    }
    @JvmStatic
    @InverseMethod("int_to_str")
    fun to_int(value: String):Int? {
        return value.toInt()
    }
    }
}