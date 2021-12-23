package com.example.jclists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jclists.ui.theme.JCListsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JCListsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ListsWithoutRecycling()
                }
            }
        }
    }
}

@Composable
fun ListsWithoutRecycling() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        for (i in 1..50) {
            var stateCB = remember {
                mutableStateOf(false)
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)) {
                Checkbox(checked = stateCB.value, onCheckedChange = {
                    stateCB.value = it
                }, Modifier.padding(12.dp))

                Text(
                    text = "Item $i",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    textAlign = TextAlign.Start,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ListsWithRecycling() {
    val scrollState = rememberScrollState()
    LazyColumn {

        items(80) {

            Text(
                text = "Item $it",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }

        itemsIndexed(
            listOf("This", "is", "Jetpack", "Compose")
        ) { index, item ->

            Text(
                text = "$item $index",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }

    }
}
