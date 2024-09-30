package com.example.imagenesrandom

import android.os.Bundle
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    var result by remember { mutableIntStateOf(0) }

    val image = when (result){
        1 -> R.drawable.rocktransgresivo
        2 -> R.drawable.deltoya
        3 -> R.drawable.materialdefectuoso
        4 -> R.drawable.yominoriaabsoluta
        5 -> R.drawable.cancionesprohibidas
        else -> R.drawable.cancionesprohibidas
    }


Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result = Random.nextInt(1,6) }) {
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