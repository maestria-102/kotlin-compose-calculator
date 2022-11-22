package com.example.calculadora

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LocalButton(text: String, modifier: Modifier = Modifier, function: () -> Unit) {
    Box(modifier = modifier
        .background(Color.Gray)
        .border(1.dp, Color.Black)
        .padding(10.dp)
        .clickable(onClick = function),
        contentAlignment = Alignment.Center) {
        Text(text = text, color = Color.White, fontSize = 30.sp, textAlign = TextAlign.Center ,modifier = Modifier.fillMaxWidth(),)
    }
}

@Composable
fun Input() {

}

val calcButtons = arrayOf(
    arrayOf("7", "4", "1", "C"),
    arrayOf("8", "5", "2", "0"),
    arrayOf("9", "6", "3", "="),
    arrayOf("/", "*", "-", "+")

)

@Preview
@Composable
fun CalculatorGrid() {

    Row(
        Modifier
            .fillMaxWidth()
            .width(IntrinsicSize.Min)
            .height(IntrinsicSize.Min)
    ) {


        calcButtons.map { calcCols ->
            Column(Modifier.weight(1f)) {
                calcCols.map {
                    LocalButton(text = it) {}
                }
            }
        }

        Column(
            Modifier
                .weight(1f)
                .fillMaxHeight(4f)) {

            LocalButton(text = "<-", modifier = Modifier.weight(1f)) {}
            LocalButton(text = "=", modifier = Modifier.weight(1f)) {}

        }

    }

}