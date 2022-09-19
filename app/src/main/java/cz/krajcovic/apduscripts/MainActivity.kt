package cz.krajcovic.apduscripts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cz.krajcovic.apduscripts.ui.theme.ApduScriptsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwitchPreview(2)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchPreview(previewVersion: Int = 3) {
    when (previewVersion) {
        1 -> TestTextContent()
        2 -> MessageCard(name = "Dusan")
        3 -> JetpackCompose()
        else -> CreateDefaultContent()
    }
}

@Composable
fun TestTextContent() {
    ApduScriptsTheme {
        Text("Hello world")
    }
}

@Composable
fun JetpackCompose() {
    ApduScriptsTheme {
        Card {
            val expander by remember { mutableStateOf(false) }
            Column(Modifier.clickable { expander != expander }) {
            Image(painterResource(R.drawable.jetpack_compose_icon))
                AnimatedVisibility(visible = expander) {
                    Text(text = "Jetpack compose", style = MaterialTheme.typography.h2)
                }

            }
        }
    }
}

@Composable
fun CreateDefaultContent() {
    ApduScriptsTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            MessageCard("Android")
        }
    }
}

@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name!")
}