package com.example.workoutmanger11.android.workoutTracker.presentation.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.tween
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.workoutmanger11.util.ExerciseBuilderObj
import com.example.workoutmanger11.workoutTracker.domain.models.TrackedExerciseItemModule

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TrackedExerciseItem(modifier1:Modifier,unEmphaseBackground:Color,trackedExerciseItemModule: TrackedExerciseItemModule) {

    val showSets = remember { mutableStateOf(false) }



        Card(
            modifier = modifier1
                .fillMaxWidth()
                .background(unEmphaseBackground)
        ) {

            Box(modifier = modifier1.fillMaxSize()) {
                Column {


                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text =  trackedExerciseItemModule.exerciseName,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }


                    Spacer(modifier = Modifier.height(8.dp))

                    AnimatedContent(
                        showSets.value,
                        transitionSpec = {
                            slideIntoContainer(
                                animationSpec = tween(300, easing = EaseIn),
                                towards = AnimatedContentTransitionScope.SlideDirection.Right
                            ).with(
                                slideOutOfContainer(
                                    animationSpec = tween(300, easing = EaseIn),
                                    towards = AnimatedContentTransitionScope.SlideDirection.Left
                                )
                            )
                        }, label = ""
                    ) {
                        if (it) {
                            LazyRow {
                                items(trackedExerciseItemModule.setsTargets.size) {
                                    SetItem(trackedExerciseItemModule.setsTargets.get(it), theIndex = it)
                                    Spacer(modifier = Modifier.width(12.dp))
                                }
                            }
                        } else {
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
                    }
                }

                Box(modifier = Modifier.rotate(32f).offset(x=8.dp,y=-13.dp).
                    clickable { showSets.value = !showSets.value }
                ) {

                    Text(
                        text = "4",
                        Modifier.offset(x = 9.dp),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = "Sets",
                        Modifier.offset(y = 16.dp),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = "X",
                        Modifier.offset(x = 36.dp, y = 4.dp),
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = TextUnit(30f, TextUnitType.Sp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }


            }
        }

    }


    @Composable
    fun SetItem(exerciseBuilderObj: ExerciseBuilderObj,theIndex: Int) {

        Column(
            modifier = Modifier
                .border(2.dp, MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(16.dp))
                .background(
                    MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(16.dp)
                )
                .padding(9.dp)
        ) {

            Text(
                text = "Set $theIndex",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Reps : ${exerciseBuilderObj.reps.value}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.align(Alignment.Start)
            )
            Text(
                text = "Weight : ${exerciseBuilderObj.weight.value}KG ",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(top = 3.dp)
            )


        }

    }







@Preview
@Composable
fun SetItemPreview() {
    //SetItem()
    //TrackedExerciseItem(Modifier,MaterialTheme.colorScheme.primaryContainer)
}