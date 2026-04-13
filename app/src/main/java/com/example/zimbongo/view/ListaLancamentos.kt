package com.example.zimbongo.view


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.zimbongo.model.Lancamento

@Composable
fun ListaLancamentos(
    lancamentos: List<Lancamento>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(lancamentos) { lancamento ->

            val status = if (lancamento.pago) "Pago" else "Pendente"

            ListItem(
                headlineContent = { Text(lancamento.descricao) },
                supportingContent = {
                    Text("${lancamento.data} - R$ ${lancamento.valor}")
                },
                trailingContent = {
                    Text(status)
                }
            )
        }
    }
}