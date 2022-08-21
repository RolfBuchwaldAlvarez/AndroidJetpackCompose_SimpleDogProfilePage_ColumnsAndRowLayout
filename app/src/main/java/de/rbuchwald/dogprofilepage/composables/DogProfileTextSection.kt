package de.rbuchwald.dogprofilepage.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.rbuchwald.dogprofilepage.model.data.DogProfile

@Composable
fun DogProfileTextSection(
    dogProfile: DogProfile,
    topSpacer: Int = 40,
    middleSpacer: Int = 20,
    bottomSpacer: Int = 50
) {

    Spacer(modifier = Modifier.height(topSpacer.dp))
    Text(text = dogProfile.headText, fontSize = 20.sp, fontWeight = FontWeight.Bold, style = TextStyle(color = Color.Gray))
    Spacer(modifier = Modifier.height(middleSpacer.dp))
    Text(text = dogProfile.bodyText, modifier = Modifier.padding(start = 30.dp, end = 30.dp), textAlign = TextAlign.Center)
    Spacer(modifier = Modifier.height(bottomSpacer.dp))

}