package cz.krajcovic.apduscripts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cz.krajcovic.apduscripts.ui.theme.ApduScriptsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           DefaultPreview(2)

        }
    }
}

@Composable
fun TestTextContent() {
    ApduScriptsTheme {
        Text("Hello world")
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview(previewVersion: Int = 2) {
    when(previewVersion) {
        1 -> TestTextContent()
        2 -> MessageCard(name = "Dusan")
        else -> CreateDefaultContent()
    }
}