package com.example.zimbongo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zimbongo.data.repository.LancamentoRepository
import com.example.zimbongo.model.Lancamento
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collectLatest

class LancamentoViewModel(
    private val repository: LancamentoRepository
) : ViewModel() {

    private val _lancamentos = MutableStateFlow<List<Lancamento>>(emptyList())
    val lancamentos: StateFlow<List<Lancamento>> = _lancamentos

    init {
        carregarLancamentos()
    }

    fun carregarLancamentos() {
        viewModelScope.launch {
            repository.listar().collectLatest { lista: List<Lancamento> ->
                _lancamentos.value = lista
            }
        }
    }

    fun salvar(lancamento: Lancamento) {
        viewModelScope.launch {
            repository.inserir(lancamento)
        }
    }
}