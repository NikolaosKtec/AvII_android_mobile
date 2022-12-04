package com.example.segundaprova_jogos.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.segundaprova_jogos.model.Jogo

@Database(entities = [Jogo::class], version = 3, exportSchema = false)
@TypeConverters(JogoConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun jogo_dao():JogoDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "jogos.db")
                .fallbackToDestructiveMigration()
                .build()
    }

}
