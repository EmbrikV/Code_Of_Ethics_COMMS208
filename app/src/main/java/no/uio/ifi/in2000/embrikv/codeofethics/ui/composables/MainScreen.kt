package no.uio.ifi.in2000.embrikv.codeofethics.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import no.uio.ifi.in2000.embrikv.codeofethics.model.Code
import no.uio.ifi.in2000.embrikv.codeofethics.ui.viewModels.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onCodeClick: (Int) -> Unit
) {
    val uiState = viewModel.uiState

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            uiState.isLoading ->
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

            uiState.errorMessage != null ->
                Text(
                    text = "Error: ${uiState.errorMessage}",
                    modifier = Modifier.align(Alignment.Center)
                )

            else -> LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(uiState.items, key = { it.number }) { code ->
                    CodeListItem(code = code, onClick = { onCodeClick(code.number) })
                }
            }
        }
    }
}

@Composable
fun CodeListItem(code: Code, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(code.color.toInt()),
            contentColor = Color.LightGray

        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "#${code.number}",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = code.title, fontSize = 20.sp)
        }
    }
}
