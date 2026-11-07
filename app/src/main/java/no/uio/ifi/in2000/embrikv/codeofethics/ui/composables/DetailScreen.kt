package no.uio.ifi.in2000.embrikv.codeofethics.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import no.uio.ifi.in2000.embrikv.codeofethics.model.Code

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    code: Code?,
    onBack: () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if(code != null) "#${code.number} ${code.title}" else "")},
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons
                            .AutoMirrored
                            .Filled
                            .ArrowBack,
                            contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = code?.let { Color(it.color.toInt()) } ?: Color.Gray,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) {innerPadding ->
        if(code != null) {
            HorizontalDivider()
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "About the topic",
                        modifier = Modifier.padding(vertical = 16.dp),
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = code.info,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Code",
                        modifier = Modifier.padding(vertical = 16.dp),
                        fontWeight = FontWeight.Bold
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        for (c in code.code) {
                            Text(
                                text = "- $c",
                            )
                        }
                    }
                }
            }
        }else{
            Text(
                text = "Couldn't find the code",
                modifier = Modifier.padding(innerPadding).padding(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDetailScreen() {
    DetailScreen(
        code = Code(
            1,
            "Rule number one",
            "After years behind this thing, much ist discovered \nMore info \nMore \nMore",
            listOf("Do something nice"),
            color =  4283433105
        ),
        onBack = {}
    )
}
