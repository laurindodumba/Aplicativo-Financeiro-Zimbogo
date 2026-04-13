package com.example.zimbongo.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zimbongo.data.repository.LancamentoRepository

class LancamentoViewModelFactory(
    private val repository: LancamentoRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LancamentoViewModel::class.java)) {
            return LancamentoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}