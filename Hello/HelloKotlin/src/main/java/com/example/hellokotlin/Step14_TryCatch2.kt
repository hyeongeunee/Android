package com.example.hellokotlin

import java.lang.NumberFormatException

fun main() {

    // 아래와 같은 try~catch 문이 가능하다
    var str = "1000"
    var str2 = "천"

    var result2 = try {
        // 예외가 발생하지 않는 경우 대입할 값
        Integer.parseInt(str)
    } catch (nfe: NumberFormatException) {
        // 예외가 발생하는 경우 대입될 값
        0
    }
    println("result2:${result2}")
}