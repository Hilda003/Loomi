import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.sp

@Composable
fun CompleteCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF708D68), shape = RoundedCornerShape(16.dp)) // Warna hijau dengan rounded corners
            .padding(horizontal = 24.dp, vertical = 16.dp), // Padding kiri kanan
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CompletedItem(
            iconRes = R.drawable.ic_check_circle,
            title = "Completed",
            subtitle = "10 hours"
        )

        Divider(
            modifier = Modifier
                .width(1.dp)
                .height(40.dp)
                .background(Color.White)
        )

        CompletedItem(
            iconRes = R.drawable.ic_schedule,
            title = "Completed",
            subtitle = "10 hours"
        )
    }
}

@Composable
fun CompletedItem(iconRes: Int, title: String, subtitle: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(40.dp) // Ukuran lingkaran
                .background(Color.White, shape = CircleShape), // Background lingkaran putih
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(20.dp), // Ukuran ikon lebih kecil agar pas di lingkaran
                colorFilter = ColorFilter.tint(Color(0xFF708D68)) // Warna ikon hijau gelap
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
        Text(
            text = subtitle,
            color = Color.White.copy(alpha = 0.8f),
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCompletedDesign() {
    CompleteCard()
}
