package com.example.jetpackbasiclayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.sourceInformation
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackbasiclayout.ui.theme.JetPackBasicLayoutTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.checkScrollableContainerConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackBasicLayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    BussinessCard(
                        name = "John Dev",
                        title = "Senior Android Developer",
                        phone = "+84 123 435 323",
                        social = "@john.dev",
                        email = "johndev@gmail.com",
                        modifier = Modifier.padding(innerPadding)
                    )
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
fun BussinessCard(name: String, title: String, phone: String, social: String, email: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.avatar)
    val phoneIcon = painterResource(R.drawable.phone)
    val socialIcon = painterResource(R.drawable.share)
    val emailIcon = painterResource(R.drawable.email)

    Column(
        modifier = Modifier
                    .fillMaxSize()
                    .background(Color(210, 232, 212))
    ) {
        Column (
            modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(top = 250.dp)
        ){
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .background(Color.Black)
            )
            Text(
                text = name,
                fontSize = 40.sp,
                color = Color.Black,
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = title,
                fontSize = 15.sp,
                color = Color(17, 117, 69),
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
        }
        Column (
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 100.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = phoneIcon,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = phone,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = modifier.padding(start = 30.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = socialIcon,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = social,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = modifier.padding(start = 30.dp)
                )
            }

            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = emailIcon,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = email,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = modifier.padding(start = 30.dp)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun BussinessCardPreview() {
    JetPackBasicLayoutTheme {
        BussinessCard(
            name = "John Dev",
            title = "Senior Android Developer",
            phone = "+84 123 435 323",
            social = "@john.dev",
            email = "johndev@gmail.com"
        )
    }
}