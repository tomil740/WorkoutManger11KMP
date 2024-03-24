package com.example.workoutmanger11.android.workoutTracker.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.math.RoundingMode

@Composable
fun WeekSumBarCover(
    modifier: Modifier) {


    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    bottomStart = 50.dp,
                    bottomEnd = 50.dp
                )
            )
            .background(MaterialTheme.colorScheme.primary)
            .padding(
                horizontal = 8.dp,
                vertical = 16.dp
            )
    ) {


        Text(
            text = "WeekOverView", style = MaterialTheme.typography.titleLarge, modifier =
            modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterHorizontally)
                .padding(start = 40.dp, end = 40.dp), color = Color.White
        )

        Spacer(modifier = modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            UnitDisplay(
                amount = 33.toBigDecimal().setScale(2, RoundingMode.UP).toFloat(),
                unit = "hours",
                amountColor = MaterialTheme.colorScheme.onPrimary,
                amountTextSize = 40.sp,
                unitColor = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.align(Alignment.Bottom)
            )


            Text(
                text = "Your Gal is:",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            UnitDisplay(
                amount = 46.toBigDecimal().setScale(2, RoundingMode.UP).toFloat(),
                unit = "Hour",
                amountColor = MaterialTheme.colorScheme.onPrimary,
                amountTextSize = 40.sp,
                unitColor = MaterialTheme.colorScheme.onPrimary,
            )
        }

        Spacer(modifier = Modifier.height(18.dp))


        WeekSumBar(
            weekTarget = 46f, 33f, Modifier
                .fillMaxWidth()
                .height(30.dp)
        )

    }


    }


