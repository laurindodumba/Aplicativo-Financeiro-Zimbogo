package com.example.zimbongo.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.zimbongo.model.Lancamento

@Database(entities = [Lancamento::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun lancamentoDao(): LancamentoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "lancamentos_db"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}