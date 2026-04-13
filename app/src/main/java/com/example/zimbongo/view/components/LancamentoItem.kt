package com.example.zimbongo.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbDownOffAlt
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.zimbongo.model.Lancamento
import com.example.zimbongo.util.formatar

@Composable
fun LancamentoItem(lancamento: Lancamento) {

    val cor = if (lancamento.tipo == "Despesa")
        Color(0xFFCF5355)
    else
        Color(0xFF00984E)

    val icon = if (lancamento.pago)
        Icons.Filled.ThumbUp
    else
        Icons.Filled.ThumbDownOffAlt

    val valorFormatado = if (lancamento.tipo == "Despesa")
        "- ${formatar(lancamento.valor)}"
    else
        formatar(lancamento.valor)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(icon, null, tint = cor)

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.fillMaxWidth()) {

            Text(lancamento.descricao)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(lancamento.data)
                Text(valorFormatado, color = cor)
            }
        }
    }
}