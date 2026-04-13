package com.example.zimbongo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DicasDeFinancasScreen(onOpenLink: (String) -> Unit,
                          navController: NavController) {

    val links = listOf(
        "Educação financeira básica" to "https://www.serasa.com.br/educacao-financeira/",
        "Como economizar dinheiro" to "https://www.nubank.com.br/blog/",
        "Investimentos para iniciantes" to "https://www.btgpactual.com/blog",
        "Controle de gastos" to "https://www.guiabolso.com.br/"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Dicas de Finanças",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        links.forEach { item ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onOpenLink(item.second) }
            ) {
                Text(
                    text = item.first,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}