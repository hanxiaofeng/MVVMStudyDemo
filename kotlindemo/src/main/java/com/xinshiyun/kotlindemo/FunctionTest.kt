package com.xinshiyun.kotlindemo

import android.content.res.Resources
import android.util.TypedValue
import android.widget.TextView


fun alsoTest() {

    val alsoResult = "Hello111".also {
        println("value = $it")
    }

    println("result value = $alsoResult")
}


fun letTest() {

    val alsoResult = "let Hello222".let {
        println("let value = $it")
        1
    }

    println("let result value = $alsoResult")
}

private lateinit var name: String
private val pwd: String by lazy {
    println("----- 我执行了")
    "123456"
}

fun applyTest() {
    println(pwd)
    println(pwd)

    /*val applyResult = "apply Hello333".apply {
        println("apply value = $this")
    }

    println("apply result value = $applyResult")


    val floatValue = 100f.dp*/
}


fun getStudentInfo(
    name: String = "张三",
    age: Int = 20,
    address: String = "江苏南京",
    sex: String = "男"
): String {
    return "$name,$age,$sex,$address"
}

//object修饰的单例
object CityTest

//懒汉式 @Synchronized保证线程安全
class CityTest1 {
    companion object {
        private var instance: CityTest1? = null
            get() {
                if (null == field) {
                    field = CityTest1()
                }
                return field
            }

        @Synchronized
        fun get(): CityTest1 {
            return instance!!
        }
    }
}

//lazy特性,非首次调用只返回结果
class CityTest2 {
    companion object {
        val instance: CityTest2 by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            CityTest2()
        }
    }
}

//静态内部类的方式
class CityTest3 {
    companion object {
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder = CityTest3()
    }
}

fun Int.toSpString(): String {
    return "[$this]"
}


class Company {
    private var address: String? = null
}


private val String.upper
    get() = this.toUpperCase()

//dp值转像素值px
val Float.dp: Float
    get() = android.util.TypedValue.applyDimension(
        android.util.TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics
    )

fun testMethod() {
    val runResult = 1.run {
        println("run : $this")
        100
    }

    println("runResult : $runResult")

    val applyResult = 1.apply {
        println("apply : $this")
    }

    println("applyResult : $applyResult")

    val alsoResult = 1.also {
        println("also : $it")
    }

    println("alsoResult : $alsoResult")

    val letResult = 1.let {
        println("let : $it")
        100
    }

    println("letResult : $letResult")

    val withResult = with(1) {
        println("with : $this")
        100
    }

    println("withResult : $withResult")
}


fun doSomething(param: Int, method: (Int) -> String): String {
    return method(param)
}

fun doSomething(param: Int, str: String, method: (Int, String) -> String): String {
    return method(param, str)
}

fun <T> doKotlin(param: T, param2: T, method: (T, T) -> T): T {
    return method(param, param2)
}


fun <T, R> doKotlin2(param: T, param2: R, method: (T, R) -> R): R {
    return method(param, param2)
}


/*fun <T, R> T.doAndroid(method: (T) -> R): R {
    return method(this)
}*/

fun <T, R> T.doAndroid(method: T.() -> R): R {
    return method()
}


fun create(init: Student.() -> Unit): Student {
    val student = Student()
    student.init()
    return student
}

fun main() {

    val student = create {
        name = "张三"
        age = 20
    }


    /*"Hello".doAndroid {
        "100"
    }*/

    /*val result = "Hello".doAndroid {
        "100"
    }
    println(result)*/

    /* val result = doKotlin2("张三", true) { a, _ ->
         return@doKotlin2 a == "张三"
     }
     println(result)*/

    /*val result = doKotlin(1, 2) { a, b ->
        return@doKotlin a + b
    }
    println(result)*/

    /*val result = doSomething(100, "调用我了") { a, b ->
        val result = a * 2
        return@doSomething "$result -- $b"
    }
    println(result)*/

    /*val result = doSomething(100) {
        val result = it * 2
        return@doSomething "result :$result"
    }
    println(result)
*/
    /*doSomething {
        println("我是高阶函数的lambda类型的参数")
    }*/

    /*repeat(8) {
        println("it : $it")
    }*/

    /*val list = mutableListOf<Int>(20, 8, 18, 78, 9, 19)

    list.forEach {
        it.takeIf { it >= 20 }?.let {
            println("it : $it")
        }
    }
*/
//    val result = 100.takeIf { it - 10 < 0 }
//    println("result : $result")
//    testMethod()

//    println("abc".upper)

//    println(2.toSpString())

    /*println(CityTest)
    println(CityTest)

    println(CityTest1.get())
    println(CityTest1.get())

    println(CityTest2.instance)
    println(CityTest2.instance)

    println(CityTest3.instance)
    println(CityTest3.instance)*/

    /*val name = "张三"
    println("你好,我是$name")

    val a = 1
    val b = 10
    println("a+b=${a + b}")*/

//    val result = getStudentInfo(age = 19)
//    println(result)
//    val cityInfo = CityInfo("","")

//    println(pwd)
//    println(pwd)

//    alsoTest()
//    letTest()
//    applyTest()
}