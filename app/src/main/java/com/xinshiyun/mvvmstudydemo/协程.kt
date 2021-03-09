package com.xinshiyun.mvvmstudydemo

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class CoroutineTest(override val coroutineContext: CoroutineContext) : CoroutineScope by MainScope(){

    private var listData = mutableListOf<String>()

    fun test() {

        launch {
            val result = async {
                println("---------------代码开始")
                Thread.sleep(2000)
                listData.add("执行结束啦")
            }

            val over = result.await()
            over.run {
                println("list size = ${listData.size}")
            }

            println("---------------代码结尾")
        }

    }


    fun test2() {
        val job = launch(context = Dispatchers.IO) {

            while (isActive) {
                Thread.sleep(500)
                println("---------runing")
            }

        }

        launch(context = Dispatchers.IO){
            Thread.sleep(5000)
            job.cancelAndJoin()
        }
    }

}


fun main() {

//    val coroutineTest = CoroutineTest()

}