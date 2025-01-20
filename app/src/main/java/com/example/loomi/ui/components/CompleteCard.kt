import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.loomi.R
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip

@Composable
fun CompleteCard(

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF90A892))
            .clip(RoundedCornerShape(16.dp))
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        CompletedItem(
            iconRes = R.drawable.ic_check_circle,
            text = "Completed\n10 materials"
        )

        Divider(
            modifier = Modifier
                .width(1.dp)
                .height(40.dp)
                .background(Color.White)
        )

        CompletedItem(
            iconRes = R.drawable.ic_schedule,
            text = "Completed\n10 hours"
        )
    }
}

@Composable
fun CompletedItem(iconRes: Int, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = text,
            color = Color.White,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCompletedDesign() {
    CompleteCard()
}
