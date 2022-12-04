package com.example.segundaprova_jogos.view_model

import android.util.Log
import androidx.lifecycle.*
import androidx.navigation.Navigation
import com.example.segundaprova_jogos.R
import com.example.segundaprova_jogos.model.Jogo
import com.example.segundaprova_jogos.repository.JogoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.stream.Collectors.toList
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(var repository: JogoRepository) : ViewModel() {
    private var _on_click:MutableLiveData<Boolean> = MutableLiveData(false)
    var on_click:LiveData<Boolean> = _on_click
    var jogos:LiveData<List<Jogo>> = repository.getAlljogo().asLiveData()

    fun on_load() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                jogos = repository.getAlljogo().asLiveData()
            }
        }
        Log.i("jogo?", jogos.value?.size.toString())

    }
    fun click_event() {
        _on_click.value = true
    }

    fun finish_event() {
        on_load()
        _on_click.value = false
    }
}