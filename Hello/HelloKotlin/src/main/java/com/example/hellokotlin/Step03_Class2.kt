package com.example.hellokotlin
/*
class Person constructor(name: String) {
    // 필드 선언
    var name: String

    // 초기화 블럭
    init {
        // 생성자의 인자로 전달받은 값을 매개 변수에 저장
        this.name = name
    }
}
*/

class Member(var num: Int, var name: String, var addr: String)


// 위를 줄이면 아래와 같다
// var or val 을 생성자의 인자에 선언하면 전달받은 값이 자동으로 같은 이름의 필드가
// 만들어 지면서 값이 필드에 대입된다.
// var 은 수정이 가능한 필드가 만들어지고, val 은 수정이 불가능한 필드가 만들어진다.
class Person(var name: String) // var / val 선언안해도 오류는 안나는데 필드가 안만들어짐

fun main() {
    var p1 = Person("현근")
    println("p1.name : " + p1.name)
    println(p1)

    // Member 객체 생성
    var m1 = Member(1, "현구닝", "역삼")
    println("번호:${m1.num} 이름:${m1.name} 주소:${m1.addr}")
    println(m1)

    // 수정 가능한 List 객체 얻어내서 참조값을 members 라는 상수에 담기
    var members: MutableList<Member> = mutableListOf<Member>()
    // type 추론이 가능하기 때문에 members2 의 type 생략 가능
    var members2 = mutableListOf<Member>()
    // in java >> List<Member> members

    // List 의 add 메소드를 이용해서 Member 객체의 참조값 저장하기
    members.add(m1)
    members.add(Member(2, "현근2", "강남"))

    // List 의 forEach( ) 함수를 호출하면서 함수를 전달하면 전달한 함수의 매개 변수에
    // List 에 저장된 아이템이 순서대로 전달된다.
    members.forEach(fun(item) {
        println(item)
    })
}