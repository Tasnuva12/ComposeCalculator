package com.example.composecalculator

sealed class CalculatorOperations(val symbol: String) {
    object Add : CalculatorOperations("+") {
        override fun toString() = symbol // Override to return symbol
    }
    object Subtract : CalculatorOperations("-") {
        override fun toString() = symbol // Override to return symbol
    }
    object Division : CalculatorOperations("/") {
        override fun toString() = symbol // Override to return symbol
    }
    object Multiplication : CalculatorOperations("*") {
        override fun toString() = symbol // Override to return symbol
    }
}
