package com.xinshiyun.mvvmstudydemo

import android.util.Log


enum class Color{
    RED,ORANGE,BLUE,GREEN
}

fun getWarmth(color: Color):String {
    return when(color){
        Color.BLUE -> "cold"
        Color.ORANGE,Color.RED -> "warm"
        Color.GREEN -> "neutral"
    }
}
fun main(args: Array<String>) {
    println(getWarmth(Color.RED))

    for (item in 1 until 5){
        println("cur item = $item")
    }

    //HashSet
    val set = hashSetOf<Int>(1,2,3)

    //ArrayList
    val list = arrayListOf<Int>(1,2,3)

    for (item in list){
        println("item :$item")
    }

    //HashMap
    val map = hashMapOf<Int,String>(1 to "张三", 2 to "李四")

    for ((index,element) in map){
        println("key:$index,value:$element")
    }

    println("max = ${max(b = 101)}")

}

fun max(a:Int = 100,b:Int = 80)= run { if (a>b) a else b }




