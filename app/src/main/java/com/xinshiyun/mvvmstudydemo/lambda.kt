package com.xinshiyun.mvvmstudydemo


class LambdaTest() {

    fun methodOne() {


    }
}

data class Mail(val address:String)


fun main() {

    val list = listOf<Int>(1, 2, 3, 14, 5, 6, 7)
    val result = list.maxBy { it }
    println("result : $result")

    //如果需要把一小段代码封闭在一个代码块中，可以使用库函数run
    run { println("--------------------------------------") }

    //lambda表达式
    val sum = {a:Int,b:Int -> a+b}
    //直接调用lambda表达式
    run { println("sum = ${sum(1,2)}") }

    val listAdd = listOf<Mail>(Mail("南京"),Mail("北京111"))
    val curMail = listAdd.maxBy { it.address.length }
    println("max length mail = ${curMail!!.address}")
}