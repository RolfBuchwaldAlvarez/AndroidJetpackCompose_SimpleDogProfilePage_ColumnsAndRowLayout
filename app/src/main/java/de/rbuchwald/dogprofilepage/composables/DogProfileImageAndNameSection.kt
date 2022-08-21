package de.rbuchwald.dogprofilepage.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.rbuchwald.dogprofilepage.model.data.DogProfile

@Composable
fun DogProfileImageAndNameSection(
    imageId: Int,
    contentDescription: String = "",
    dogProfile: DogProfile,
    topSpacer: Int = 50,
    middleSpacer: Int = 20,
    bottomSpacer: Int = 40,
    imageSize: Int = 140,
    border: Double = 1.5
) {

    Spacer(modifier = Modifier.height(topSpacer.dp))
    Image(
        painter = painterResource(imageId),
        contentDescription = contentDescription,
        modifier = Modifier
            .size(imageSize.dp)
            .clip(CircleShape)
            .border(border.dp, color = Color.Gray, CircleShape)
    )
    Spacer(modifier = Modifier.height(middleSpacer.dp))
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(dogProfile.name, fontSize = 35.sp, fontWeight = FontWeight.Bold, style = TextStyle(color = Color.Gray))
        Text(dogProfile.breed)
        Text(dogProfile.country)
    }
    Spacer(modifier = Modifier.height(bottomSpacer.dp))

}