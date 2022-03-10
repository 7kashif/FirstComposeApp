package com.kashif.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kashif.firstcompose.ui.MessageItem
import com.kashif.firstcompose.ui.sampleMessages
import com.kashif.firstcompose.ui.theme.FirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeTheme {
                Conversation(messages = sampleMessages)
            }
        }
    }
}

@Composable
fun MessageBody(name: String, isExpended: Boolean) {
    Text(
        text = name,
        maxLines = if (isExpended) name.length - 1 else 1
    )
}

@Composable
fun MessageAuthor(author: String) {
    Text(
        text = author,
        color = MaterialTheme.colors.secondaryVariant,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun MessageCard(item: MessageItem) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var isExpended by remember {
            mutableStateOf(false)
        }
        val surfaceColor: Color by animateColorAsState(
            targetValue =
            if (isExpended) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )
        Image(
            painter = painterResource(item.profilePic),
            contentDescription = "Picture of a husky.",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Surface(
            shape = MaterialTheme.shapes.medium, elevation = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isExpended = !isExpended },
            color = surfaceColor
        ) {
            Column(
                modifier = Modifier.padding(all = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                MessageAuthor(author = item.author)
                Spacer(modifier = Modifier.height(8.0.dp))
                MessageBody(name = item.message, isExpended)
            }
        }
    }
}


@Composable
fun Conversation(messages: ArrayList<MessageItem>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(item = message)
        }
    }
}

@Preview(name = "Light Mode", showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    FirstComposeTheme {
        Conversation(messages = sampleMessages)
    }
}