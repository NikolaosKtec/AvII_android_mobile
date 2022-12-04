package com.example.segundaprova_jogos

import android.app.Application
import com.example.segundaprova_jogos.database.AppDatabase
import com.example.segundaprova_jogos.database.JogoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getDatabase(applicationContext: Application): AppDatabase {
        return AppDatabase.invoke(applicationContext)
    }

    @Singleton
    @Provides
    fun getDao(database:AppDatabase):JogoDao{
        return database.jogo_dao()
    }
}