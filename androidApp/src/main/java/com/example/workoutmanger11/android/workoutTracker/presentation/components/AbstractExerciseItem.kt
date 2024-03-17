package com.example.workoutmanger11.android.workoutTracker.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.workoutmanger11.workoutTracker.domain.models.AbstractExerciseModule

@Composable
fun AbstractExerciseItem(
    abstractExerciseModule : AbstractExerciseModule? =null,
    onTrack : () -> Unit ,
    onItemClicked : () -> Unit,
    isEmphase : Boolean,
    modifier: Modifier = Modifier
    ) {

    val editEnable = remember { mutableStateOf(false) }
    val trackBut = remember { mutableStateOf("enter-Data") }
    var unEmphaseColor = MaterialTheme.colorScheme.onPrimaryContainer
    var unEmphaseBackground = MaterialTheme.colorScheme.primaryContainer

    if(isEmphase){
         unEmphaseColor = MaterialTheme.colorScheme.onSurfaceVariant
         unEmphaseBackground = MaterialTheme.colorScheme.surfaceVariant
    }

    Card (modifier= modifier
        .background(unEmphaseBackground)
    ){
        Column(
            modifier = modifier.fillMaxSize()

        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = abstractExerciseModule?.exercisesAbstract?.name ?: "Pull-Up",
                    style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onPrimaryContainer )
            }
            
            Spacer(modifier = Modifier.height(8.dp))

            if(editEnable.value) {
                trackBut.value = "Track"
                LazyRow{
                    items(4){
                        ExerciseBuilderItem(unEmphaseColor=unEmphaseColor, setIndex = it+1)
                        Spacer(modifier = Modifier.width(12.dp))
                    }
                }
            }else{
                trackBut.value ="enter-Data"
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    //will take the maucelss list from the abstract exercise and implemnt it down here
                    MuscleItem("Shoulders")
                    MuscleItem("Back", isMain = true)
                    MuscleItem("Arms")

                }
            }

            Row(modifier = Modifier
                .fillMaxSize()
                .padding(start = 11.dp)
                , horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom) {
                Text(text = "Rp reps : 12",
                    style = MaterialTheme.typography.bodySmall, color = unEmphaseColor ,
                    modifier = Modifier.offset(y=28.dp) )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 11.dp), horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.Bottom) {
                Text(text = "Rp weight : Body Weight + 20KG",
                    style = MaterialTheme.typography.bodySmall, color = unEmphaseColor)

               ElevatedButton(onClick = { editEnable.value = !editEnable.value}) {

                       Text(text = trackBut.value)

                }

            }

        }
    }

}

@Composable
fun MuscleItem(muscleName: String , isMain : Boolean= false) {

    var theModifier : Modifier = Modifier.offset(y=10.dp)
    var height = 45.dp
    var width = 82.dp
    var textStyle = MaterialTheme.typography.titleSmall

    if(isMain){
         width = 92.dp
         height = 55.dp
         theModifier = Modifier
        textStyle = MaterialTheme.typography.titleLarge
    }

    Box(modifier = theModifier
        .size(width = width, height = height)
        .padding(all = 4.dp)
        .border(2.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(16.dp))
        .background(MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(16.dp))) {

        Text(
            text = muscleName,
            style = textStyle,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.align(Alignment.Center)
        )
    }

}






@Preview
@Composable
fun AbstractExerciseItemPreview() {
    AbstractExerciseItem(onTrack = {}, onItemClicked = {}, isEmphase = true)
}