package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingApp()
                }
            }
        }
    }
}

@Composable
fun GreetingApp(){

    Box(
        modifier = Modifier
            .background(Color(0xFFC8E6C9))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
            ) {
                Greeting1(
                    image = painterResource(R.drawable.android_logo),
                    fullName = stringResource(R.string.full_name),
                    title = stringResource(R.string.title)
                )
            }

            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Greeting2(
                    phone = stringResource(R.string.phone),
                    email1 = stringResource(R.string.email1),
                    email2 = stringResource(R.string.email2)
                )
            }
        }
    }
}

@Composable
fun Greeting1(image: Painter, fullName: String, title: String, modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color(0xFF052241))
        ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
        }
        Text(
            text = fullName,
            fontSize = 35.sp,
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = title,
            color = Color(0xFF1B6E40),
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Greeting2(
    phone: String,
    email1: String,
    email2: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 16.dp)) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "Phone Icon",
                tint = Color(0xFF23814E),
                modifier = Modifier.weight(0.4f)
            )
            Text(
                text = phone,
                modifier = Modifier
                    .weight(0.6f),
                textAlign = TextAlign.Start,
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "Share Icon",
                tint = Color(0xFF23814E),
                modifier = Modifier.weight(0.4f)

            )
            Text(
                text = email1,
                modifier = Modifier
                    .weight(0.6f),
                textAlign = TextAlign.Start
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 36.dp)) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email Icon",
                tint = Color(0xFF23814E),
                modifier = Modifier.weight(0.4f)
            )
            Text(
                text = email2,
                modifier = Modifier
                    .weight(0.6f),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        GreetingApp()
    }
}