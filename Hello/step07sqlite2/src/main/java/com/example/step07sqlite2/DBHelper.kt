package com.example.step07sqlite2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/*
    SQLiteOpenHelper 클래스는 추상 클래스이기 때문에 추상 메소드를 오버라이드 해야한다.
    DBHelper 클래스의 대표 생성자에서 부모 생성자에 전달할 값을 받아야 한다.
    SQLiteOpenHelper 클래스의 생성자에 필요한 값을 전달해야 한다.
 */
class DBHelper constructor(
    context : Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    init {

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = """
            CREATE TABLE todo 
            (NUM INTEGER PRIMARY KEY AUTOINCREMENT, CONTENT TEXT, REGDATE TEXT)
        """.trimIndent()
        db!!.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, i: Int, i1: Int) {
        db?.execSQL("DROP TABLE IF EXISTS todo")
        onCreate(db)
        db.execSQL()
    }
}