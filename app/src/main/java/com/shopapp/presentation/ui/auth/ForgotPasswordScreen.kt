// presentation/ui/auth/ForgotPasswordScreen.kt
package com.shopapp.presentation.ui.auth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MarkEmailRead
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shopapp.presentation.viewmodel.ForgotPasswordViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(
    onBack: () -> Unit,
    onGoToConfirm: () -> Unit,
    viewModel: ForgotPasswordViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    var email by remember { mutableStateOf("") }

    LaunchedEffect(state.error) {
        val error = state.error ?: return@LaunchedEffect
        snackbarHostState.showSnackbar(error)
        viewModel.clearError()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Recuperar contraseña") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                        )
                    }
                },
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (!state.emailSent) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    modifier = Modifier.size(72.dp),
                    tint = MaterialTheme.colorScheme.primary,
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "Ingresa tu correo electrónico y te enviaremos un enlace para restablecer tu contraseña.",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Spacer(Modifier.height(32.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Correo electrónico") },
                    placeholder = { Text("ejemplo@correo.com") },
                    singleLine = true,
                    enabled = !state.isLoading,
                    keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                    ),
                    modifier = Modifier.fillMaxWidth(),
                )
                Spacer(Modifier.height(24.dp))
                Button(
                    onClick = { viewModel.requestReset(email) },
                    enabled = email.isNotBlank() && !state.isLoading,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                ) {
                    if (state.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(22.dp),
                            strokeWidth = 2.dp,
                            color = MaterialTheme.colorScheme.onPrimary,
                        )
                    } else {
                        Text("Enviar enlace")
                    }
                }
            } else {
                Icon(
                    imageVector = Icons.Default.MarkEmailRead,
                    contentDescription = null,
                    modifier = Modifier.size(72.dp),
                    tint = MaterialTheme.colorScheme.primary,
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "Revisa tu correo",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold,
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "Te enviamos un correo con las instrucciones. Copia el uid y el token que encontrarás en el enlace para continuar con el restablecimiento.",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Spacer(Modifier.height(32.dp))
                Button(
                    onClick = onGoToConfirm,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                ) {
                    Text("Tengo el código → Restablecer contraseña")
                }
                Spacer(Modifier.height(12.dp))
                TextButton(onClick = onBack) {
                    Text("Volver al inicio de sesión")
                }
            }
        }
    }
}
