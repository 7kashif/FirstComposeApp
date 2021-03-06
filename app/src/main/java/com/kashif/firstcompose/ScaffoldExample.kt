package com.kashif.firstcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kashif.firstcompose.ui.theme.FirstComposeTheme

@Composable
fun ScaffoldExample() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Favorites", "Music", "Places", "Bluetooth")
    val itemIcons = listOf(
        Icons.Filled.Favorite,
        Icons.Filled.MusicNote,
        Icons.Filled.Place,
        Icons.Filled.Bluetooth
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Layouts Example")
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation {
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = selectedItem == index,
                        icon = { Icon(itemIcons[index], item) },
                        label = { Text(text = item) },
                        onClick = { selectedItem = index }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                shape = MaterialTheme.shapes.large,
                content = { Icon(Icons.Filled.Edit,null)},
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary, CircleShape)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(text = "Hi There")
            Text(text = "This is the test text for scaffold.")
        }
    }
}


@Preview(name = "Light Mode", showSystemUi = true, showBackground = true)
@Composable
fun ScaffoldExamplePreview() {
    FirstComposeTheme {
        ScaffoldExample()
    }
}