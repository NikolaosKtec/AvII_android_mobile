package com.example.segundaprova_jogos.view_model


import android.util.Log
import androidx.lifecycle.*
import com.example.segundaprova_jogos.model.Jogo
import com.example.segundaprova_jogos.repository.JogoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CadastraJogoViewModel @Inject constructor(private var repository: JogoRepository)  : ViewModel() {
    private var _is_cadastrado:MutableLiveData<Boolean> = MutableLiveData(false)
    var is_cadastrado:LiveData<Boolean> =  _is_cadastrado
    var jogo = MutableLiveData<Jogo>()

    fun cadastrarButtonEv(){



        viewModelScope.launch {
            withContext(Dispatchers.IO){

                jogo.value?.let { repository.insert(it.copy()) }
                jogo.value?.let { Log.i("what?", it.titulo) }
            }
        }
        _is_cadastrado.value = true
        Log.i("ecad",_is_cadastrado.value.toString())
    }

    fun post_cadastro() {
        _is_cadastrado.value = false
        Log.i("ecad2",_is_cadastrado.value.toString())
    }


}