package com.example.workoutmanger11.android.workoutTracker.presentation.components

import android.view.MenuItem
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Try1() {

    val listState = rememberLazyListState()

    LaunchedEffect(key1 = listState.layoutInfo) {
        if(!listState.isScrollInProgress){
            listState.scrollToItem(listState.firstVisibleItemIndex+1)
            listState.scrollToItem(listState.firstVisibleItemIndex-1)
        }
    }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        
        LazyColumn(state = listState, modifier = Modifier.size(40.dp)){
            items(10){
                MenuItem(name = it.toString())
            }
        }
        
        Text(text = "The chose number is : ${listState.firstVisibleItemIndex}", modifier = Modifier.offset(y=100.dp))
    }
}


@Composable
fun MenuItem(name:String) {
    
    Box(modifier = Modifier.size(40.dp).border(1.dp, Color.Red).padding(5.dp), contentAlignment = Alignment.Center){
        
        Text(text = name, style = MaterialTheme.typography.bodyMedium)
        
    }
    
}