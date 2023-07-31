package com.example.hellokotlin

// 클래스 정의하기
class MyCar

class YourCar {
    // 멤버 함수
    fun drive() {
        println("달려요 !")
    }
}

// 대표(primary) 생성자 클래스명 우측에 선언한다
class Ship constructor() {
    // init 블럭은 대표 생성자의 일부이다.
    init {
        // 객체를 생성하는 시점에 초기화하고 싶은 작업이 있다면 여기서 한다.
        println("Ship 클래스의 init")
    }
}

// constrictor 예약어 생략 가능
class Ship2 {
    init {
        // 객체를 생성하는 시점에 초기화하고 싶은 작업이 있다면 여기서 한다.
        println("Ship2 클래스의 init")
    }
}

// 인자로 전달 받을게 없으면 () 도 생략 가능
class Ship3 {
    init {
        // 객체를 생성하는 시점에 초기화하고 싶은 작업이 있다면 여기서 한다.
        println("Ship3 클래스의 init")
    }
}

fun main() {
    // MyCar 클래스로 객체를 생성해서 참조값을 c1 이라는 변수에 담기
    var c1 = MyCar()
    // YourCar 클래스로 객체를 생성해서 참조값을 c2 이라는 변수에 담기
    var c2: YourCar = YourCar()
    c2.drive()
}