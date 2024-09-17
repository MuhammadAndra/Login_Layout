package com.example.loginlayout

import android.content.Context
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsStartWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginlayout.ui.theme.LoginLayoutTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPage()
        }
    }
}

@Composable
fun LoginPage(modifier: Modifier = Modifier) {
    val mContext = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xffCB0074)
            ),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        Image(
            painter = painterResource(R.drawable.group_1),
            contentDescription = "gurujilogo",
            modifier = Modifier
                .width(200.dp)
                .height(100.dp),
        )
        Text(
            "Learn Graphic and UI/UX designing in Hindi\n" +
                    "for free with live projects.",
            color = Color.White,
            textAlign = TextAlign.Center,

            )
        Column {
            var email by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(100.dp)),
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        "Email Address",
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            var password by remember { mutableStateOf("") }

            TextField(
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(100.dp)),
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        "Password",
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    if (email.equals("m.andradzaki@gmail.com") && password.equals("12345678")) {
                        Toast.makeText(mContext, "Welcome Andra", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(mContext, "wrong credential", Toast.LENGTH_LONG).show()

                    }
                },
                modifier
                    .padding(horizontal = 30.dp)
                    .height(50.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xffFD8C00))

            ) {
                Text("LOGIN")
            }
            Spacer(modifier = Modifier.height(20.dp))


            Box(
                contentAlignment = Alignment.CenterEnd, modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .fillMaxWidth()
            ) {
                UnderlineText("Forgot Password")
            }
        }

        Row {
            Text(
                "Dont have account? ", color = Color.White
            )
            UnderlineText("Register now")
        }
        Row {
            LoginWithOther(R.drawable.gmail,"Google")
            Spacer(Modifier.width(20.dp))
            LoginWithOther(R.drawable.facebook,"Facebook")
            Spacer(Modifier.width(20.dp))
            LoginWithOther(R.drawable.twitter,"Twitter")
        }
        Row {
            Text(
                "By signing up, you are agree with our ", color = Color.White
            )
            UnderlineText("Terms & Condition")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginPagePreview() {
    LoginPage()
}

@Composable
fun UnderlineText(text:String) {
    val mContext = LocalContext.current

    Text(
        text,
        color = Color.White,
        style = TextStyle(
            textDecoration = TextDecoration.Underline
        ),
        modifier = Modifier.clickable {
            Toast
                .makeText(mContext, "Go to $text page", Toast.LENGTH_LONG)
                .show()
        }
    )
}

@Preview
@Composable
private fun UnderlineTextPreview() {
    UnderlineText("Terms & Condition")
}

@Composable
fun LoginWithOther(imageResource:Int,platform:String) {
    val mContext = LocalContext.current
    Image(
        modifier = Modifier
            .height(60.dp)
            .width(60.dp)
            .clip(CircleShape)
            .clickable {
                Toast
                    .makeText(mContext, "Go to $platform Login page", Toast.LENGTH_LONG)
                    .show()
            },
        painter = painterResource(imageResource),
        contentDescription = "$platform Button"
    )
}

@Preview
@Composable
private fun LoginWithOtherPreview() {
    LoginWithOther(R.drawable.gmail, platform = "Google")
}