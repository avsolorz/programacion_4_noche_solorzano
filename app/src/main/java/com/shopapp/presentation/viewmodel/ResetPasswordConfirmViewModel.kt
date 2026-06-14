// presentation/viewmodel/ResetPasswordConfirmViewModel.kt
package com.shopapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shopapp.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ResetPasswordConfirmUiState(
    val isLoading: Boolean = false,
    val resetSuccess: Boolean = false,
    val error: String? = null,
)

@HiltViewModel
class ResetPasswordConfirmViewModel @Inject constructor(
    private val repository: AuthRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ResetPasswordConfirmUiState())
    val uiState: StateFlow<ResetPasswordConfirmUiState> = _uiState.asStateFlow()

    fun confirmReset(uid: String, token: String, newPassword: String, newPassword2: String) {
        if (_uiState.value.isLoading) return
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            repository.confirmReset(uid, token, newPassword, newPassword2)
                .onSuccess {
                    _uiState.update { it.copy(isLoading = false, resetSuccess = true) }
                }
                .onFailure { e ->
                    _uiState.update { it.copy(isLoading = false, error = e.message ?: "Error al restablecer la contraseña") }
                }
        }
    }

    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }
}
