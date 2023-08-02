package com.example.hellokotlin

fun main() {
    // 수정 불가능한 Map                      mapOf( key to value, key to value, ... )
    val mem = mapOf<String, Any>("num" to 1, "name" to "김구라", "isMan" to true)
    // Map 에 저장된 데이터 참조하는 방법 1
    val num = mem.get("num")
    val name = mem.get("name")
    val isMan = mem.get("isMan")

    // Map 에 저장된 데이터 참조하는 방법 2
    val num2: Int = mem["num"] as Int // Int type 으로 casting 하기
    val name2: String = mem["name"] as String // String type 으로 casting 하기
    val isMan2: Boolean = mem["isMan"] as Boolean // Boolean type 으로 casting 하기

    // 수정불가 !
    // mem["num"] = 2
}