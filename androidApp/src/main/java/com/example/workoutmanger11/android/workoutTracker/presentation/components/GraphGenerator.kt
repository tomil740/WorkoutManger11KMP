package com.example.workoutmanger11.android.workoutTracker.presentation.components

import android.graphics.PointF
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun GraphGenerator(coulms: Int=12,rows: Int=7,dataList:List<Float> = listOf(6f,8f,9f,9f,6f,3f,5f),modifier: Modifier = Modifier) {

    var verticalFrameSize by remember { mutableStateOf( coulms.toFloat()) }


    Box(modifier = modifier, contentAlignment = Alignment.Center) {


        //generate the graph frame , the table itSelf
        GenerateGraphTable(
            coulms + 1,
            rows,
            MaterialTheme.colorScheme.tertiary,
            barsColors = MaterialTheme.colorScheme.tertiary,
            {verticalFrameSize = it},verticalFrameSize = verticalFrameSize)


        //generate the graph itSelf according to the row number passed to the table above , and the list of Data to be present int the table
        //*importent the data list must be in the range of the coulms value (could be uneturial )  *
        DrawGraph(
            verticalFrameSize = verticalFrameSize,
            examplePathData = listOf(6f,8f,9f,9f,6f,3f,5f),
            areaMarkColor = MaterialTheme.colorScheme.onPrimaryContainer,
        )

    }
}

@Composable
fun GenerateGraphTable(coulms: Int, rows:Int ,backgroundColor:Color,barsColors:Color,
                       setVerticalFrameSize:(Float)-> Unit,verticalFrameSize:Float) {

    Box(modifier = Modifier){
        Canvas(modifier = Modifier
            .padding(8.dp)
            .aspectRatio(5 / 2f)
            .fillMaxWidth()) {
            val barWithPx = 1.dp.toPx()
            drawRect(barsColors, style = Stroke(barWithPx))
            val horizontalFrameSize = size.width / rows.toFloat()
            repeat(rows) {
                val startX = horizontalFrameSize * (it + 1)
                drawLine(barsColors, start = Offset(startX, 0f), end = Offset(startX, size.height))
            }

            setVerticalFrameSize(size.height / coulms.toFloat())
            repeat(coulms) {
                val startY = verticalFrameSize * (it)
                drawLine(barsColors, start = Offset(0f, startY), end = Offset(size.width, startY))
            }
        }
    }
}

@Composable
fun DrawGraph(verticalFrameSize:Float,examplePathData: List<Float>,areaMarkColor:Color = Color.Green ){

    var graphSize by remember { mutableStateOf(true) }


    val theSize by animateIntAsState(targetValue = if(graphSize) 450 else 135)


    Box(modifier = Modifier
        .clickable { graphSize = !graphSize },
        contentAlignment = Alignment.Center
    ) {

        Spacer(
            modifier = Modifier
                .padding(8.dp)
                .aspectRatio(5 / 2f)
                .fillMaxWidth()
                .drawWithCache {
                    onDrawBehind {

                        val resultList = mutableListOf<Float>()
                        for (i in examplePathData) {
                            resultList.add((verticalFrameSize) * i)
                        }
                        val path = generateSmothPath(resultList, size)

                        val fillPath = Path()
                        fillPath.addPath(path)
                        fillPath.lineTo(size.width, size.height)
                        fillPath.lineTo(0f, size.height)
                        fillPath.close()

                        //mark with color
                        drawPath(path, areaMarkColor, style = Stroke(2.dp.toPx()))

                        val brush =
                            Brush.verticalGradient(
                                listOf(
                                    areaMarkColor.copy(alpha = 0.7f),
                                    Color.Transparent
                                )
                            )

                        drawPath(fillPath, brush = brush, style = Fill)

                    }
                }
        )
    }
}

fun generateSmothPath(data: List<Float>, size: Size): Path {
    val path = Path()
    val numberEntries = data.size
    //that the constent X size to draw (represent a day)
    val weekWidth = size.width / numberEntries

    //for the Y one we will use the data from my list ...

    var currentX =0f
    var currentY =0f
    data.forEachIndexed { i, balance ->


        if (i == 0) {
            currentX = 0f
            currentY = size.height
            path.moveTo(0f, size.height)
        }
        // else {
        val balanceX = (i + 1) * weekWidth
        val balanceY = size.height - balance

        val controlPoint1 = PointF((balanceX + currentX) / 2f, currentY)
        val controlPoint2 = PointF((balanceX + currentX) / 2f, balanceY)


        path.cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y,
            balanceX,balanceY)
        currentX = balanceX
        currentY = balanceY


        //}
    }
    return path
}
@Preview
@Composable
fun preview() {
    GraphGenerator()

}
