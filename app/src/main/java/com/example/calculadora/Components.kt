package com.example.calculadora

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LocalButton(text: String, modifier: Modifier = Modifier, textColor: Color = Color.Black, function: () -> Unit) {
    Box(modifier = modifier
        .background(Color.hsl(0f, 0f, 0.93f, 1f))
        .border(1.dp, Color.hsl(0f, 0f, 0.62f, 1f))
        .padding(10.dp)
        .clickable(onClick = function),
        contentAlignment = Alignment.Center) {
        Text(text = text, color = textColor, fontSize = 30.sp, textAlign = TextAlign.Center ,modifier = Modifier.fillMaxWidth(),)
    }
}

@Composable
fun Input() {

}

val calcButtons = arrayOf(
    arrayOf("7", "4", "1", "C"),
    arrayOf("8", "5", "2", "0"),
    arrayOf("9", "6", "3", "."),
    arrayOf("/", "*", "-", "+")

)


var blueColor = Color.hsl(213f, 0.74f, 0.57f, 1f)

@Preview
@Composable
fun CalculatorGrid() {

    Surface() {
        Column(
            Modifier
                .fillMaxWidth()
                .width(IntrinsicSize.Min)) {
            TextField(value = "3600x24", onValueChange = {},
                modifier =
                Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                textStyle = TextStyle(fontSize = 40.sp, color = Color.Black, textAlign = TextAlign.End),
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .width(IntrinsicSize.Min)
                    .height(IntrinsicSize.Min)
            ) {

                var colorText: Color = Color.Black;
                calcButtons.mapIndexed { index, calcCols ->
                    Column(Modifier.weight(1f)) {



                        calcCols.map {

                            if (it == "C") {
                                colorText = blueColor
                            } else {
                                colorText = Color.Black
                            }

                            if (index == calcButtons.size - 1) {
                                colorText = blueColor
                            }

                            LocalButton(text = it, modifier = Modifier.padding(2.dp), colorText ){}
                        }
                    }
                }


                Column(
                    Modifier
                        .weight(1f)
                        .fillMaxHeight(4f)
                        .padding(2.dp)
                ) {

                    LocalButton(text = "<-", modifier = Modifier.weight(1f), blueColor) {}
                    Spacer(modifier = Modifier.height(4.dp))
                    LocalButton(text = "=", modifier = Modifier.weight(1f), blueColor) {}

                }

            }

        }
    }





}