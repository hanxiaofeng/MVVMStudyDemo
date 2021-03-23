package com.xinshiyun.kotlindemo


class Student {

    var name: String? = null

    var age: Int? = null




}

/**
 * 高阶函数
 *
 * Student.()的含义是需要传入其扩展函数，或者其下的函数
 *
 * 这个是无参数的高阶函数
 */
fun stuStudyInfo(student: Student, info: Student.() -> String): String {
    return student.info()
}

/**
 * 普通高阶函数
 *
 * Student.()的含义是需要传入其扩展函数，或者其下的函数
 *
 */
fun stuStudyInfoCommon(info: () -> String): String {
    return info()
}

fun main() {

    /*val student = Student()
    val result = stuStudyInfo(student) {

    }*/

//    println("result : $result")
}