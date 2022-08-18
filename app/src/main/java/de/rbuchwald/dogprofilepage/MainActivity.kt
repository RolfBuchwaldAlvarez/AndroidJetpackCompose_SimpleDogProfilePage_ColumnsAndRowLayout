package de.rbuchwald.dogprofilepage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.rbuchwald.dogprofilepage.ui.theme.DogProfilePageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogProfilePageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DogProfileCard(
                        dogProfile = DogProfile(
                            "Robbi",
                            "Greek Mongrel",
                            "Germany",
                            "Most beautiful dog in the world",
                            "Robbi loves to go for a walk or to be lying in the sun. He gives you the 'mediteranian' dog vibe. You think he might not like you? Have some treats ready at hand and he certainly will fall in love with you!"
                        )
                    )
                }
            }
        }
    }
}

data class DogProfile(
    val name: String,
    val breed: String,
    val country: String,
    val headText: String,
    val bodyText: String
)

@Composable
fun DogProfileCard(dogProfile: DogProfile) {
    var followers by remember { mutableStateOf(20768) }
    var following by remember { mutableStateOf(345) }
    var likes by remember { mutableStateOf(54678) }

    Column(modifier = Modifier.fillMaxSize()) {
        Card(elevation = 6.dp, modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Spacer(modifier = Modifier.height(50.dp))
                Image(
                    painter = painterResource(R.drawable.profile_robbi),
                    contentDescription = "Dog Picture",
                    modifier = Modifier
                        .size(140.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, color = Color.Gray, CircleShape)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(dogProfile.name, fontSize = 35.sp, fontWeight = FontWeight.Bold, style = TextStyle(color = Color.Gray))
                    Text(dogProfile.breed)
                    Text(dogProfile.country)
                }
                Spacer(modifier = Modifier.height(40.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = followers.toString())
                        Text(text = "Followers", fontWeight = FontWeight.Bold, style = TextStyle(color = Color.Gray))
                    }
                    // Spacer(modifier = Modifier.width(10.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = following.toString())
                        Text(text = "Following", fontWeight = FontWeight.Bold, style = TextStyle(color = Color.Gray))
                    }
                    // Spacer(modifier = Modifier.width(10.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = likes.toString())
                        Text(text = "Likes", fontWeight = FontWeight.Bold, style = TextStyle(color = Color.Gray))
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
                Text(text = dogProfile.headText, fontSize = 20.sp, fontWeight = FontWeight.Bold, style = TextStyle(color = Color.Gray))
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = dogProfile.bodyText, modifier = Modifier.padding(start = 30.dp, end = 30.dp), textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(onClick = { followers++ }) {
                    Text(text = "Add followers")
                }
                Button(onClick = { following++ }) {
                    Text(text = "Add following")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.Center) {
                Button(onClick = { likes++ }) {
                    Text(text = "Add likes")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDogProfileCard() {
    DogProfileCard(
        dogProfile = DogProfile(
            "Robbi",
            "Greek Mongrel",
            "Germany",
            "Most beautiful dog in the world",
            "Robbi loves to go for a walk or to be lying in the sun. He gives you the 'mediteranian' dog vibe. You think he might not like you? Have some treats ready at hand and he certainly will fall in love with you!"
        )
    )
}