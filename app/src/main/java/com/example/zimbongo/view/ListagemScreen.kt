package com.example.zimbongo.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zimbongo.model.Lancamento
import com.example.zimbongo.viewmodel.LancamentoViewModel
import com.example.zimbongo.view.components.BottomBar
import com.example.zimbongo.view.components.LancamentoItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListagemScreen(
    viewModel: LancamentoViewModel,
    onAdicionarPressed: () -> Unit
) {

    val lancamentos by viewModel.lancamentos.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lançamentos") },
                actions = {
                    IconButton(onClick = { viewModel.carregarLancamentos() }) {
                        Icon(Icons.Default.Refresh, contentDescription = "Atualizar")
                    }
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(onClick = onAdicionarPressed) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar")
            }
        },

        bottomBar = {
            BottomBar(lancamentos)
        }
    ) { padding ->

        if (lancamentos.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("Nenhum lançamento encontrado")
            }
        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                items(lancamentos) { item ->
                    LancamentoItem(lancamento = item)
                }
            }
        }
    }
}