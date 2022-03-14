package com.kashif.firstcompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kashif.firstcompose.ui.theme.FirstComposeTheme

class PracticeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            FirstComposeTheme {

            }
        }
    }
}






@Preview(name = "Light Mode", showSystemUi = true, showBackground = true)
@Composable
fun DefaultPracticeActivityPreview() {
    FirstComposeTheme {

    }
}