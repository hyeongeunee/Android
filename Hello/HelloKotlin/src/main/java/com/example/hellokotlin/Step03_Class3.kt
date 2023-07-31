package com.example.hellokotlin

class Cat constructor() {
    // init 블럭은 primary 생성자의 일부
    init {
        println("야옹쓰가 생겼어요!")
    }

    // 뒤늦은 초기화가 가능한 필드 lateinit 예약어 붙여서 선언하기
    lateinit var name: String
    // var name: String? = null

    constructor(name: String) : this() { // this() primary 생성자 호출하는 표현식이다.
        println("야옹이의 이름은:${name}")
        this.name = name
    }
}

class Dog constructor() {
    init {
        println("댕댕쓰가 생겼어요!")
    }

    // 필드
    // null 값을 허용하고 싶으면 type 뒤에 ? 를 붙인다
    var name: String? = null

    constructor(name: String) : this() {
        // null 이 가능한 type 공간에 null 이 불가능한 type 공간에 담긴 값을 대입하는 것은 가능
        this.name = name
    }
}

fun main() {
    val c1 = Cat("톰캣")
    val c2 = Cat()
    println(c1.name)
    c2.name = "키티"
    println(c2.name)

    // null 값이 가능한 data type 은 type 뒤에 ? 를 붙여주어야 한다.
    // String type 과 String? type 은 다른 type 으로 간주된다.
    var myName: String? = null
    myName = "현근"
    myName = null

    var myNum: Int? = null
    myNum = 999
    myNum = null

    var d1 = Dog("바둑쓰")
    var d2 = Dog()
    println(d1.name)
    println(d2.name)

}