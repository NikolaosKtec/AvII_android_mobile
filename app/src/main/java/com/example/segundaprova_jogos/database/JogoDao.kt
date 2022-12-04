package com.example.segundaprova_jogos.database

import androidx.room.*
import com.example.segundaprova_jogos.model.Jogo
import kotlinx.coroutines.flow.Flow

@Dao
interface JogoDao {

    @Insert
    fun create(jogo: Jogo)

//    @Delete
//    fun remove(j:Jogo)

    @Update
    fun update(j:Jogo)

    @Query("SELECT * FROM Jogo")
    fun list(): Flow<List<Jogo>>
    @Query("SELECT * FROM Jogo WHERE id = :id")
    fun listById(id:Long):Jogo?
}