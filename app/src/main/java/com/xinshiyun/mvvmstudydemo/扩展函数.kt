package com.xinshiyun.mvvmstudydemo

import java.lang.StringBuilder


fun String.lastChar(): Char = this[this.length - 1]

//父类
open class Person {}

//子类
class Student : Person()

fun Person.show() = println("我是父类")
fun Student.show() = println("我是子类")

//扩展属性
val String.lastChar: Char
    get() {
        return this[this.length - 1]
    }

//可变参数
fun sum(vararg items: Int): Int {
    var sum = 0
    for (index in items) {
        sum += index
    }
    return sum
}

fun main() {

    val person: Person = Student()
    person.show()

    println("Android".lastChar)

    val listValue = listOf<Int>(1, 3, 4, 5, 6, 7)
    println(sum(*listValue.toIntArray()))
    println(sum(1, 22, 3, 4, 5))

    val splitStr = "K.ot-li,n".split("[.\\-,]".toRegex())

    var sb = StringBuilder()
    for (charItem in splitStr) {
        sb.append("$charItem    #    ")
    }

    println("split result:${sb.toString()}")

    val commonListener = CommonListener()
    commonListener.show()
}