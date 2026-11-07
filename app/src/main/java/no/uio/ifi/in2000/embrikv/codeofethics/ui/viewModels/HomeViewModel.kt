package no.uio.ifi.in2000.embrikv.codeofethics.ui.viewModels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.embrikv.codeofethics.data.CodeOfEthicsDataSource
import no.uio.ifi.in2000.embrikv.codeofethics.data.CodeRepository
import no.uio.ifi.in2000.embrikv.codeofethics.model.Code

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    data class UiState(
        val isLoading: Boolean = false,
        val items: List<Code> = emptyList(),
        val errorMessage: String? = null
    )

    private val repository = CodeRepository(CodeOfEthicsDataSource(application))

    var uiState by mutableStateOf(UiState())
        private set

    init { loadCodes() }

    fun loadCodes() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, errorMessage = null)
            try {
                uiState = uiState.copy(isLoading = false, items = repository.getCodes())
            } catch (e: Exception) {
                uiState = uiState.copy(isLoading = false, errorMessage = e.localizedMessage)
            }
        }
    }
}