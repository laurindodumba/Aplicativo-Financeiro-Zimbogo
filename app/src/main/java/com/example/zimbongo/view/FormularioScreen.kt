package com.example.zimbongo.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Notes
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zimbongo.model.Lancamento
import com.example.zimbongo.viewmodel.LancamentoViewModel
import java.text.SimpleDateFormat
import java.util.*
import com.example.zimbongo.view.components.BottomBar
import com.example.zimbongo.view.components.LancamentoItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioScreen(
    navController: NavController,
    viewModel: LancamentoViewModel
) {

    var descricao by remember { mutableStateOf("") }
    var valor by remember { mutableStateOf("") }
    var dataSelecionada by remember { mutableStateOf<Long?>(null) }
    var pago by remember { mutableStateOf(false) }
    var tipo by remember { mutableStateOf("Despesa") }

    val datePickerState = rememberDatePickerState()
    var showDatePicker by remember { mutableStateOf(false) }

    val dataFormatada = dataSelecionada?.let {
        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(it))
    } ?: ""

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Novo lançamento") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = {
                        if (descricao.isNotBlank() && valor.isNotBlank()) {
                            viewModel.salvar(
                                Lancamento(
                                    descricao = descricao,
                                    valor = valor.toDoubleOrNull() ?: 0.0,
                                    data = dataFormatada,
                                    pago = pago,
                                    tipo = tipo
                                )
                            )
                            navController.popBackStack()
                        }
                    }) {
                        Icon(Icons.Default.Check, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            OutlinedTextField(
                value = descricao,
                onValueChange = { descricao = it },
                label = { Text("Descrição") },
                leadingIcon = {
                    Icon(Icons.AutoMirrored.Filled.Notes, null)
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = valor,
                onValueChange = { valor = it },
                label = { Text("Valor") },
                leadingIcon = {
                    Icon(Icons.Filled.AttachMoney, null)
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = dataFormatada,
                onValueChange = {},
                readOnly = true,
                label = { Text("Data") },
                trailingIcon = {
                    IconButton(onClick = { showDatePicker = true }) {
                        Icon(Icons.Default.DateRange, null)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            if (showDatePicker) {
                DatePickerDialog(
                    onDismissRequest = { showDatePicker = false },
                    confirmButton = {
                        TextButton(onClick = {
                            dataSelecionada = datePickerState.selectedDateMillis
                            showDatePicker = false
                        }) { Text("OK") }
                    },
                    dismissButton = {
                        TextButton(onClick = { showDatePicker = false }) {
                            Text("Cancelar")
                        }
                    }
                ) {
                    DatePicker(state = datePickerState)
                }
            }

            Row {
                Checkbox(checked = pago, onCheckedChange = { pago = it })
                Text("Pago")
            }

            Row {
                RadioButton(
                    selected = tipo == "Despesa",
                    onClick = { tipo = "Despesa" }
                )
                Text("Despesa")

                Spacer(modifier = Modifier.width(16.dp))

                RadioButton(
                    selected = tipo == "Receita",
                    onClick = { tipo = "Receita" }
                )
                Text("Receita")
            }
        }
    }
}