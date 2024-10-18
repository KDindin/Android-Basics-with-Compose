package com.example.birthdaycard

import  android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage(stringResource(R.string.happy_birthday_text),
                                              stringResource(R.string.signature_text))
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(message:String, from: String){
    val image = painterResource(R.drawable.androidparty)
    // Create a box to overlap image and texts
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }
}
@Composable
fun BirthdayGreetingWithText(message:String, from: String){
    // Create a column so that texts don't overlap
    Column{
        Text(text = message,
            fontSize= 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp)
                .wrapContentWidth(align = Alignment.CenterHorizontally))
        Text(text = from,
             fontSize = 24.sp,
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(start = 16.dp, end = 16.dp)
                 .wrapContentWidth(align = Alignment.CenterHorizontally)

        )
    }

}

@Preview(showBackground = true)
@Composable
private fun BirthdayGreetingWithImagePreview() {
    BirthdayCardTheme {
        BirthdayGreetingWithImage(stringResource(R.string.happy_birthday_text),
                                  stringResource(R.string.signature_text))
    }
}