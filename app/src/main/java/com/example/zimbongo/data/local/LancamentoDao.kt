package com.example.zimbongo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.zimbongo.model.Lancamento
import kotlinx.coroutines.flow.Flow

@Dao
interface LancamentoDao {

    @Insert
    suspend fun inserir(lancamento: Lancamento)

    @Query("SELECT * FROM lancamentos ORDER BY id DESC")
    fun listar(): Flow<List<Lancamento>>
}