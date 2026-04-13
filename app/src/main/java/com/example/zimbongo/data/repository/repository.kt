package com.example.zimbongo.data.repository

import com.example.zimbongo.data.local.LancamentoDao
import com.example.zimbongo.model.Lancamento
import kotlinx.coroutines.flow.Flow

class LancamentoRepository(
    private val dao: LancamentoDao
) {

    suspend fun inserir(lancamento: Lancamento) {
        dao.inserir(lancamento)
    }

    fun listar(): Flow<List<Lancamento>> {
        return dao.listar()
    }

}