package no.uio.ifi.in2000.embrikv.codeofethics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import no.uio.ifi.in2000.embrikv.codeofethics.ui.theme.CodeOfEthicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CodeOfEthicsTheme {
                AppNavigation()
            }
        }
    }
}
