package com.shopapp.presentation.ui.admin.users

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shopapp.presentation.viewmodel.SendNotificationViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendNotificationScreen(
    onBack: () -> Unit,
    viewModel: SendNotificationViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var subject by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var userIdStr by remember { mutableStateOf("") }

    LaunchedEffect(state.result) {
        val result = state.result ?: return@LaunchedEffect
        val msg = buildString {
            append("✅ Enviado a ${result.sent} usuario(s)")
            if (result.failed > 0) append(" — ${result.failed} fallido(s)")
        }
        scope.launch { snackbarHostState.showSnackbar(msg) }
        viewModel.clearResult()
    }

    LaunchedEffect(state.error) {
        val error = state.error ?: return@LaunchedEffect
        scope.launch { snackbarHostState.showSnackbar("Error: $error") }
        viewModel.clearError()
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("Enviar notificación") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            OutlinedTextField(
                value = subject,
                onValueChange = { subject = it },
                label = { Text("Asunto") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Mensaje") },
                minLines = 5,
                maxLines = 10,
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                value = userIdStr,
                onValueChange = { userIdStr = it.filter { c -> c.isDigit() } },
                label = { Text("ID de usuario (opcional)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    if (userIdStr.isEmpty()) {
                        Text("Sin ID → se envía a todos los usuarios activos no-staff")
                    } else {
                        Text("Con ID → se envía solo al usuario #$userIdStr")
                    }
                },
            )

            val userId = userIdStr.toIntOrNull()
            val buttonText = if (userIdStr.isNotEmpty()) "Enviar al usuario #$userIdStr" else "Enviar a todos"
            val enabled = subject.isNotBlank() && message.isNotBlank() && !state.isLoading

            Button(
                onClick = { viewModel.send(subject, message, userId) },
                enabled = enabled,
                modifier = Modifier.fillMaxWidth(),
            ) {
                Icon(Icons.Default.Send, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text(buttonText)
            }

            if (state.isLoading) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }
        }
    }
}
