package com.example.segundaprova_jogos.repository

import com.example.segundaprova_jogos.database.JogoDao
import com.example.segundaprova_jogos.model.Jogo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class JogoRepository @Inject constructor(private var jogoDao:JogoDao) {

    fun insert(j:Jogo) {
        jogoDao.create(j)
    }

    fun update(j : Jogo){
        jogoDao.update(j)
    }

    fun getjogoById(id:Long): Jogo? {
        return jogoDao.listById(id)
    }

    fun getAlljogo(): Flow<List<Jogo>>{
        return jogoDao.list()
    }

}