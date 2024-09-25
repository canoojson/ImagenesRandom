package com.example.imagenesrandom

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.imagenesrandom.ui.theme.ImagenesRandomTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImagenesRandomTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImagenesRandom(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ImagenesRandom(modifier: Modifier = Modifier) {

    val imageResIds = listOf(
        R.drawable.rocktransgresivo,
        R.drawable.deltoya,
        R.drawable.materialdefectuoso,
        R.drawable.yominoriaabsoluta,
        R.drawable.cancionesprohibidas
    )

    var selectedImageResId by remember { mutableStateOf(R.drawable.rocktransgresivo) }

    fun showRandomImage() {
        val randomIndex = Random.nextInt(0, 5)
        selectedImageResId = imageResIds[randomIndex]
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Image(
                painter = painterResource(id = selectedImageResId),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { showRandomImage() }) {
            Text(text = "Mostrar imagen aleatoria")
        }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ImagenesRandomTheme {
            Greeting("Android")
        }
    }