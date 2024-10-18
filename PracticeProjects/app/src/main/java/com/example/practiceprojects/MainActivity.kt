package com.example.practiceprojects

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practiceprojects.ui.theme.PracticeProjectsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeProjectsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    ComposeArticle()
                }
            }
        }
    }
}



@Composable
fun ComposeArticle(
){
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        Row(modifier = Modifier
            .weight(1f)) {
                Part(title = "part1",
                    paragraph = "part1",
                    color = Color.Green,
                    modifier = Modifier.weight(1f)
                )
                Part(title = "part3",
                    paragraph = "part3",
                    color = Color.Cyan,
                    modifier = Modifier
                        .weight(1f))

        }
        Row(modifier = Modifier
            .weight(1f)) {
            Part(title = "part2",
                paragraph = "part2",
                color = Color.Yellow,
                modifier = Modifier.weight(1f))
            Part(title = "part4",
                paragraph = "part4",
                color = Color.LightGray,
                modifier = Modifier.weight(1f))
        }
    }
}
@Composable
private fun Part(title: String, paragraph: String, color: Color, modifier: Modifier){
     Column(modifier = modifier
         .fillMaxSize()
         .background(color)
         .padding(16.dp),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center,

     ) {
            Text(text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 16.dp))
            Text(text = paragraph,
                textAlign = TextAlign.Justify)

     }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PracticeProjectsTheme {
        ComposeArticle()
    }
}