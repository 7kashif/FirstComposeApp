package com.kashif.firstcompose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kashif.firstcompose.ui.MessageItem
import com.kashif.firstcompose.ui.sampleMessages
import com.kashif.firstcompose.ui.theme.FirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeTheme{

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = name)
}

@Composable
fun MessageCard(item: MessageItem) {
    Row(
        modifier = Modifier
            .padding(all = 8.0.dp)
            .wrapContentSize(align = Alignment.TopStart, unbounded = false),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(item.profilePic),
            contentDescription = "Picture of a husky.",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(verticalArrangement = Arrangement.Center) {
            Greeting(name = item.author)
            Spacer(modifier = Modifier.height(8.0.dp))
            Greeting(name = item.message)
        }
    }
}

@Composable
fun Conversation(messages: ArrayList<MessageItem>) {
    LazyColumn {
        items(messages) {message->
            MessageCard(item = message)
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    FirstComposeTheme {
        Conversation(messages = sampleMessages)
    }
}