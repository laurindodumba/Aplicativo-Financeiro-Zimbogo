package com.example.zimbongo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lancamentos")
data class Lancamento(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val descricao: String,
    val valor: Double,
    val data: String,
    val pago: Boolean,
    val tipo: String
)