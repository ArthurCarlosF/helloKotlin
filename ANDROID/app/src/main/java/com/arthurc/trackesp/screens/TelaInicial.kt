package com.arthurc.trackesp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arthurc.trackesp.Greeting

@Composable
fun TelaInicial(
    viewModel: TelaInicialViewModel = TelaInicialViewModel()
) {
    val dados by viewModel.users.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item { Greeting("Android") }
        item {
            Text(
                "Clique para chamar a api",
                Modifier.clickable {
                    viewModel.fetchUsers()
                }
            )
        }
        items(dados) { user ->
            Text(user.name)
        }
    }
}