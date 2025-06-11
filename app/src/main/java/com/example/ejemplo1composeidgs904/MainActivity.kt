package com.example.ejemplo1composeidgs904

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo1ComposeIDGS904Theme {
                ListaPersonajes()
            }
        }
    }
}
data class Personaje(val imagenResId: Int, val nombre: String,val descripcion:String)
@Composable
fun Tarjeta(personaje: Personaje) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            ImagenHeroe(personaje.imagenResId)
            InfoPersonaje(personaje)
        }
    }
}
@Composable
fun ListaPersonajes() {
    LazyColumn {
        items(listaDragonball) { personaje ->
            Tarjeta(personaje)
        }
    }
}

@Composable
fun MessageCard(nombre: String){
    Text("Hola Word  $nombre")
    Text("Hola Word 2")
}
private val personajes = listOf(
    Personaje(R.drawable.goku_normal, "Goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable"),
    Personaje(R.drawable.gohan, "Gohan", "Es el primer hijo de Son Goku y Chi-Chi"),
    Personaje(R.drawable.Androide_17_Artwork, "Androide 17", ""),
    Personaje(R.drawable.Androide_18_Artwork, "Androide 18", ""),
    Personaje(R.drawable.celula, "Cell", ""),
    Personaje(R.drawable.gogeta, "Gogeta", ""),
    Personaje(R.drawable.Jiren, "Jiren", ""),
    Personaje(R.drawable.Gotenks_Artwork, "Gotenks", ""),
    Personaje(R.drawable.Daishinkan, "Daishinkan", ""),
    Personaje(R.drawable.vegeta_normal, "Vegeta", ""),
    Personaje(R.drawable.Vegetto, "Vegetto", "")
)

@Composable
fun InfoPersonaje (personaje: Personaje){
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Nombre: ${personaje.nombre}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Descripción: ${personaje.descripcion}", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun ImagenHeroe(imagenResId: Int){
    Image(
        painter = painterResource(id = imagenResId),
        contentDescription = null,
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.tertiary)
    )
}
@Preview(showBackground = true)
@Composable
fun PreviewListaPersonajes() {

    Column {
        listaDragonball.forEach { personaje ->
            Tarjeta(personaje)
        }
    }
}