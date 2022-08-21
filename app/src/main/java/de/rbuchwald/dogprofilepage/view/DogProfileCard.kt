package de.rbuchwald.dogprofilepage.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.rbuchwald.dogprofilepage.model.data.DogProfile

@Composable
fun DogProfileCard(imageId: Int, dogProfile: DogProfile) {
    var followers by remember { mutableStateOf(20768) }
    var following by remember { mutableStateOf(345) }
    var likes by remember { mutableStateOf(54678) }

    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            elevation = 6.dp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                DogProfileImageAndNameSection(imageId = imageId, contentDescription = "Dog Picture", dogProfile = dogProfile)
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    DogProfileStats(amount = followers.toString(), text = "Followers")
                    DogProfileStats(amount = following.toString(), text = "Following")
                    DogProfileStats(amount = likes.toString(), text = "Likes")
                }
                DogProfileTextSection(dogProfile = dogProfile)
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { followers++ }) {
                    Text(text = "Add followers")
                }
                Button(onClick = { following++ }) {
                    Text(text = "Add following")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { likes++ }) {
                    Text(text = "Add likes")
                }
            }
        }
    }
}
