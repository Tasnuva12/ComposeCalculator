package com.example.composecalculator

import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecalculator.components.CalculatorButton

@Composable
fun Calculator(
    state :CalculatorState,
    modifier:Modifier= Modifier,
    viewModel: CalculatorViewModel,
    buttonSpacing: Dp =68.dp,
    onAction:(CalculatorActions)->Unit


){
    val scrollState = rememberScrollState()
  Box(modifier=modifier.fillMaxSize()
      .background(Color.DarkGray)
      .padding(16.dp)){
      Column(
          modifier=Modifier.fillMaxWidth().align(Alignment.BottomCenter).verticalScroll(scrollState),
          verticalArrangement = Arrangement.spacedBy(buttonSpacing)
      ) {
          Text(
              text=state.number1+(state.operations?:"")+state.number2,

              textAlign = TextAlign.End,
              modifier=Modifier.fillMaxWidth().padding(vertical=32.dp),
              fontWeight = FontWeight.Light,
              fontSize = 80.sp,
              color= Color.White,
              maxLines = 4,
              lineHeight = 70.sp
          )
          Row(modifier=Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
              ){
              CalculatorButton(
                  symbol = "AC",
                  modifier = Modifier.background(Color.LightGray).aspectRatio(2f).weight(2f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Clear)
                  }
              )
              CalculatorButton(
                  symbol = "DEL",
                  modifier = Modifier.background(Color.LightGray).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Delete)
                  }
              )
              CalculatorButton(
                  symbol = "/",
                  modifier = Modifier.background(Color.Magenta).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Operations(CalculatorOperations.Division))
                  }
              )
          }
          Row(modifier=Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
          ){
              CalculatorButton(
                  symbol = "7",
                  modifier = Modifier.background(Color.LightGray).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Number(7))
                  }
              )
              CalculatorButton(
                  symbol = "8",
                  modifier = Modifier.background(Color.LightGray).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Number(8))
                  }
              )
              CalculatorButton(
                  symbol = "9",
                  modifier = Modifier.background(Color.White).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Number(9))
                  }
              )
              CalculatorButton(
                  symbol = "X",
                  modifier = Modifier.background(Color.Magenta).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Operations(CalculatorOperations.Multiplication))
                  }
              )
          }
          Row(modifier=Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
          ){
              CalculatorButton(
                  symbol = "6",
                  modifier = Modifier.background(Color.LightGray).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Number(6))
                  }

              )
              CalculatorButton(
                  symbol = "5",
                  modifier = Modifier.background(Color.LightGray).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Number(5))
                  }
              )
              CalculatorButton(
                  symbol = "4",
                  modifier = Modifier.background(Color.White).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Number(4))
                  }
              )
              CalculatorButton(
                  symbol = "+",
                  modifier = Modifier.background(Color.Magenta).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Operations(CalculatorOperations.Add))
                  }
              )
          }
          Row(modifier=Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
          ){
              CalculatorButton(
                  symbol = "3",
                  modifier = Modifier.background(Color.LightGray).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Number(3))
                  }

              )
              CalculatorButton(
                  symbol = "2",
                  modifier = Modifier.background(Color.LightGray).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Number(2))
                  }
              )
              CalculatorButton(
                  symbol = "1",
                  modifier = Modifier.background(Color.White).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Number(1))
                  }
              )
              CalculatorButton(
                  symbol = "-",
                  modifier = Modifier.background(Color.Magenta).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Operations(CalculatorOperations.Subtract))
                  }
              )
          }

          Row(modifier=Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
          ){
              CalculatorButton(
                  symbol = "0",
                  modifier = Modifier.background(Color.LightGray).aspectRatio(2f).weight(2f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Number(0))
                  }

              )
              CalculatorButton(
                  symbol = ".",
                  modifier = Modifier.background(Color.LightGray).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Decimal)
                  }
              )
              CalculatorButton(
                  symbol = "=",
                  modifier = Modifier.background(Color.White).aspectRatio(1f).weight(1f),

                  color=Color.Black,
                  onClick={
                      onAction(CalculatorActions.Calculate)
                  }
              )

          }

      }
  }

}


