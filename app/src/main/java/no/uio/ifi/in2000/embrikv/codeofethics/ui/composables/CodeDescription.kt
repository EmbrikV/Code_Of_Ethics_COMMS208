package no.uio.ifi.in2000.embrikv.codeofethics.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import no.uio.ifi.in2000.embrikv.codeofethics.model.Code

@Composable
fun CodeCard(code: Code){
    val modifier = Modifier
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clip(RoundedCornerShape(16)),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {Row(
        modifier = Modifier
            .background(color = Color.Cyan)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                StringBuilder()
                    .append("#")
                    .append(code.number)
                    .toString(),
                modifier = Modifier.padding(4.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )

            for (c in code.code)
            Text(
                c,
                modifier = Modifier.padding(4.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
    }
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(code.info,
                modifier.padding(vertical = 16.dp)
                )

            for(code in code.code)
            Text(code,
                modifier.padding(vertical = 16.dp)
                )
        }
    }
}


@Preview
@Composable
private fun PreviewCodeCard(){
    CodeCard(Code(
        1,
        "Rule number one",
        "After years behind this thing, much ist discovered \nMore info \nMore \nMore",
        listOf("Do something nice"),
        4283433105
    ))
}
