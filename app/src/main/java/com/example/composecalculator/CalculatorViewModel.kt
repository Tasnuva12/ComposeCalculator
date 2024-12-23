package com.example.composecalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel:ViewModel(){


    var state by mutableStateOf(CalculatorState())
    private set

    fun onAction(calculatorActions: CalculatorActions) {
          when(calculatorActions){
              is CalculatorActions.Number->enterNumber(calculatorActions.number)
              is CalculatorActions.Decimal->enterDecimal()
              is CalculatorActions.Clear->state=CalculatorState()
              is CalculatorActions.Operations->enterOperation(calculatorActions.operation)
              is CalculatorActions.Calculate->performCalculation()
              is CalculatorActions.Delete->performDeletion()

          }
    }

    private fun enterOperation(operation: CalculatorOperations) {
         if(state.number1.isNotBlank()){
             state=state.copy(operations=operation)
         }
    }

    private fun performDeletion() {
        when{
            state.number2.isNotBlank()->state=state.copy(number2 = state.number2.dropLast(1))
            state.operations!=null->state=state.copy(
                operations = null
            )
            state.number1.isNotBlank()->state=state.copy(number1 = state.number1.dropLast(1))
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if(number1 != null && number2 != null) {
            val result = when(state.operations) {
                is CalculatorOperations.Add -> number1 + number2
                is CalculatorOperations.Subtract -> number1 - number2
                is CalculatorOperations.Multiplication -> number1 * number2
                is CalculatorOperations.Division -> number1 / number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operations = null
            )
        }

    }

    private fun enterDecimal() {
        if(state.operations==null &&!state.number1.contains(".") &&state.number1.isNotBlank()){
            state=state.copy(
                number1=state.number1+"."
            )
            return
        }else if(!state.number2.contains(".") &&state.number2.isNotBlank()){
            state=state.copy(
                number2=state.number2+"."
            )
        }
    }

    private fun enterNumber(number: Int) {
       if(state.operations==null){
           if(state.number1.length>= MAX_NUM_LENGTH){
               return
           }
           state=state.copy(number1 = state.number1+number)
           return
       }
        if(state.number2.length>= MAX_NUM_LENGTH){
            return
        }
        state=state.copy(number2 = state.number2+number)
        return
    }
    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}

