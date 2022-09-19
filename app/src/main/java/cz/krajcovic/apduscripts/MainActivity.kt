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
import cz.krajcovic.apduscripts.data.ApduMessage
import cz.krajcovic.apduscripts.models.ApduMessagesFactory
import cz.krajcovic.apduscripts.ui.theme.ApduScriptsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwitchPreview(DEFAULT_PREVIEW)
        }
    }

    companion object {
        const val DEFAULT_PREVIEW = 2
    }
}

@Preview(showBackground = true)
@Composable
fun SwitchPreview(previewVersion: Int = MainActivity.DEFAULT_PREVIEW) {
    when (previewVersion) {
        1 -> TestTextContent()
        2 -> MessageCard(ApduMessagesFactory.getFake())
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
            val expanded by remember { mutableStateOf(false) }
            Column(Modifier.clickable { expanded != expanded }) {
                Image(painterResource(R.drawable.jetpack_compose_icon), "")
                AnimatedVisibility(expanded) {
                    Text(
                        text = "Jetpack compose",
                        style = MaterialTheme.typography.h2
                    )
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
            MessageCard(ApduMessagesFactory.getFake())
        }
    }
}

@Composable
fun MessageCard(apduMessage: ApduMessage) {
    Text(text = "APDU: ${apduMessage.name}")
}