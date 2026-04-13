package com.example.zimbongo.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zimbongo.model.Lancamento

@Composable
fun BottomBar(lancamentos: List<Lancamento>) {

    val saldo = lancamentos.sumOf {
        if (it.tipo == "Receita") it.valor else -it.valor
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(16.dp)
    ) {
        Text("Saldo: R$ $saldo")
    }
}