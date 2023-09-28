package com.demo.kmmlibrary

class Calculator {
    fun add(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun sub(num1: Int, num2: Int): Int {
        return num1 - num2
    }

    fun abs(x: Int): Int {
        if (x < 0) return -x
        return x
    }
}