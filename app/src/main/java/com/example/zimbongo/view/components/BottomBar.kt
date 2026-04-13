package com.example.zimbongo.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.zimbongo.util.formatar


@Composable
fun BottomBar(saldo: Double, previsao: Double) {

    val corSaldo = if (saldo >= 0) Color(0xFF00984E) else Color(0xFFCF5355)
    val corPrevisao = if (previsao >= 0) Color(0xFF00984E) else Color(0xFFCF5355)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text("Saldo")
            Text(formatar(saldo), color = corSaldo)
        }

        Column(horizontalAlignment = Alignment.End) {
            Text("Previsão")
            Text(formatar(previsao), color = corPrevisao)
        }
    }
}