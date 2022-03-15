package com.kashif.firstcompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kashif.firstcompose.ui.theme.FirstComposeTheme

class PracticeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            FirstComposeTheme {
                GreetingsList()
            }
        }
    }
}

@Composable
fun GreetingsList(
    names: List<String> = List(1000) {
        "name #_$it"
    }
) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) {name->
            Greeting(name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    var isExpended by rememberSaveable {
        mutableStateOf(false)
    }
    val extraPadding by animateDpAsState(
        if (isExpended) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth()
            .clickable { isExpended = !isExpended },
        elevation = 4.dp
    ) {
        Column(modifier = Modifier
            .padding(all = 24.dp)
            .padding(bottom = extraPadding.coerceAtLeast(0.dp)),
        ) {
            Text(
                text = "Hell0, $name",
                fontSize = if(isExpended) 24.sp else 16.sp,
            )
        }
    }


}


@Preview(name = "Light Mode", showSystemUi = true, showBackground = true)
@Composable
fun DefaultPracticeActivityPreview() {
    FirstComposeTheme {
        GreetingsList()
    }
}