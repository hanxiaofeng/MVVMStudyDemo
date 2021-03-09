package com.xinshiyun.mvvmstudydemo

import android.view.View
import android.widget.TextView

class Outer {

    //内部类用inner关键字修饰
    inner class Child {
        fun getOuterInstance(): Outer {
            //获取外部类上下文使用this@外部类名
            return this@Outer
        }
    }
}

//父类，使用open修饰，不然默认为final无法被继承
open class BeautyPerson(open var name: String = "kotlin", var age: Int = 18) {

    override fun toString(): String {
        return "name = $name,age = $age"
    }
}

//子类，定义了同名参数，使用关键字override修饰
class Teacher(override var name: String = "老师", var sex: String) : BeautyPerson() {

    //自定义一个无参构造函数
    constructor():this(name="佚名",sex="女"){

    }

    override fun toString(): String {
        return "name = $name,age = $age,sex = $sex"
    }
}


data class MyStudent(val name:String,val age:Int)

object Company{
    fun show(){
        println("----我被调用了")
    }
}

//伴生对象可实现接口
class BanSObj(){
    companion object :View.OnClickListener{
        fun show(){
            println("----我在伴生对象里，被调用了")
        }

        override fun onClick(v: View?) {
            //测试伴生对象接口实现
        }
    }
}

fun printInfo(listener:View.OnClickListener){
    println("listener : $listener")
}

//伴生对象扩展
class Weather(val wenDu:Int){
    companion object{}
}

//可通过伴生对象直接调用该方法，但是需要伴生对象的实例作为参数
fun Weather.Companion.sunWarm(weather: Weather):String{
    return if(weather.wenDu > 20) "weather is warm." else "weather is cold."
}

fun main() {
    val beautyPerson = BeautyPerson()
    println(beautyPerson.toString())

    val teacher = Teacher()
    println(teacher.toString())

    val student = MyStudent("李四",90)
    println(student.toString())


    Company.show()

    BanSObj.show()

    printInfo(BanSObj);


    val weather = Weather(30)
    println(Weather.Companion.sunWarm(weather))
}











