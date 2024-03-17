package com.example.workoutmanger11.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.workoutmanger11.Greeting
import com.example.workoutmanger11.android.util.theme.AppTheme
import com.example.workoutmanger11.android.workoutTracker.presentation.components.AbstractExerciseItem
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Default.Add, contentDescription = null,
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }
                    ) { values ->

                        val searchText = remember { mutableStateOf("") }
                        val isFloatSearchBar = remember { mutableStateOf(true) }
                        val listState = rememberLazyListState()

                        LaunchedEffect(key1 = listState.firstVisibleItemIndex) {

                            if (listState.firstVisibleItemIndex != 0) {
                                delay(500)
                                isFloatSearchBar.value = true
                            } else {
                                delay(500)
                                isFloatSearchBar.value = false
                            }
                        }


                        LazyColumn(contentPadding = values, state = listState) {
                            if (!isFloatSearchBar.value) {
                                item {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(top = 24.dp)
                                    ) {
                                        OutlinedTextField(value = searchText.value,
                                            onValueChange = { text: String ->
                                                searchText.value = text
                                            },
                                            modifier = Modifier.align(Alignment.Center),
                                            shape = MaterialTheme.shapes.extraLarge,
                                            placeholder = {
                                                Text(text = "Enter Exercise name ")
                                            },
                                            leadingIcon = {
                                                Icon(
                                                    imageVector = Icons.Default.Search,
                                                    contentDescription = null
                                                )
                                            }
                                        )

                                    }
                                }
                            }
                            items(20) {
                                AbstractExerciseItem(modifier = Modifier
                                    .padding(16.dp)
                                    .clip(MaterialTheme.shapes.extraLarge), onTrack = {},
                                    onItemClicked = {}, isEmphase = false
                                )

                            }
                        }

                        val searchBar = remember { mutableStateOf(false) }

                        if (isFloatSearchBar.value) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 24.dp)
                            ) {
                                AnimatedVisibility(!searchBar.value,modifier = Modifier
                                    .align(Alignment.TopEnd).padding(end = 6.dp)) {
                                    Button(
                                        onClick = { searchBar.value = !searchBar.value },

                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = null
                                        )
                                    }
                                }
                                if(searchBar.value) {

                                    OutlinedTextField(value = searchText.value,
                                        onValueChange = { text: String ->
                                            searchText.value = text
                                        },
                                        modifier = Modifier
                                            .align(Alignment.TopCenter)
                                            .clip(MaterialTheme.shapes.extraLarge)
                                            .background(Color.White),
                                        shape = MaterialTheme.shapes.extraLarge,
                                        placeholder = {
                                            Text(text = "Enter Exercise name ")
                                        },
                                        leadingIcon = {
                                            Icon(
                                                imageVector = Icons.Default.Search,
                                                contentDescription = null,
                                                modifier = Modifier.clickable {
                                                    searchBar.value = !searchBar.value
                                                },
                                            )
                                        },
                                        colors = OutlinedTextFieldDefaults.colors().copy(

                                        )

                                    )
                                }

                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    AppTheme {
        GreetingView("Hello, Android!")
    }
}
