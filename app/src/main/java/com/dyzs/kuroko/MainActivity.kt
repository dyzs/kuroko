package com.dyzs.kuroko

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Hello world" + max(1,4))
    }
}

data class Person(val id: Int, val name: String)// 使用 Kotlin 的数据类声明一个 Person Bean 类

fun max(a: Int, b: Int): Int {
    val max = if (a > b) a else b
    return max
}

fun lsLeapYear(year: Int): Boolean {
    var isLeapYear = false
    if ((year % 4 == 0 && year% 100 != 0)) {// 判断是否是闰年
        isLeapYear = true
    } else {
        isLeapYear = false
    }
    return isLeapYear
}

/**
 * 类似 switch case 语法
 */
fun casesWhen(obj: Any?) {
    when (obj) {
        0,1,2,3,4,5 -> println("${obj} 是一个数字")
        "hello" -> println("${obj}是一个字符串")
        else -> println("${obj} 是默认的 default")// 表示传入什么参数类型就是什么参数类型
    }
}

fun casesInOrNotIn() {
    val x = 1
    val validNumbers = arrayOf(1,2,3)

    for (item in validNumbers) {
        print("item value:${item}")
    }

    when(x) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is out side")
        else -> {

        }
    }
}

// 用 when 语句写一个阶乘函数
fun fact(n: Int): Int {
    var result = 1
    when(n) {
        0,1 -> {
            result = 1
        }
        else -> {
            result = n * fact(n - 1)
        }
    }

    return result
}

fun casesFor(n: Int): Int {
    for (i in 1..10) {
        if (n == i) return n
        println("value of i:${i}")
    }
    (1..10).forEach() {
        println("value of i:${it}")
    }
    return n
}

fun casesSumFact(n: Int): Int {
    var sum = 0
    for (i in 1..n) {
        sum += fact(i)
    }
    return sum
}

fun casesDoWhile() {
    var y = 0
    do {
        y += 1
    } while (y < 20)
}

fun casesBreakAndContinue() {
    for (i in 1..10) {
        if (i % 2 == 0) {
            break
        }
    }
}

fun casesReturn(a: Int, b: Int): Int {
    if (a > b)
        return a - b
    else
        return a + b
}

// 函数数字面量
fun sum(a: Int, b: Int) = a + b

fun casesMax(a: Int, b: Int) = if ( a > b) a else b

/**
 * 测试匿名函数返回
 */
fun casesAnonymous() {
    val intArray = intArrayOf(1, 2, 3, 4, 5);
    intArray.forEach(fun(a: Int) {
        if (a == 3)return
        println("value of a:{$a}")
    })
}

/**
 * 在Kotlin中任何表达式都可以用标签（label）来标记。标签的格式 为标识符后跟@符号
 * like xxx@ or _xxx@
 * here@ 标签，执行指令跳转到 Lambda 表达式标签 here@ 处，继续下一个 it = 4 的遍历循环
 *
 */
fun casesAtHere() {
    val intArray = intArrayOf(1,2,3,4,5)
    intArray.forEach here@ {
        if (it == 3) return@here
        println("value of it${it}")
    }
}

fun casesNothing(msg: String): Nothing {
    throw IllegalArgumentException(msg)
}

fun casesThrow() {
    val ex:Nothing = throw Exception("YYYYYYYY") // ex需要显式声明类型为 Nothing，否则报错
}

/**
 *
 */
data class Point2(val x: Int, val  y: Int)
operator fun Point2.unaryMinus() = Point2(-x, -y)

fun casesUnaryMinus() {

}

fun casesSymbol() {
    val a = 1;
    val b = 5;
    a.plus(b)   // a+b
    a.minus(b)  //a-b
    a.times(b)  //a*b农历
    a.div(b)    //a/b
    a.rem(b)    //a%b
    a.rangeTo(b)//a..b
}


data class Counter(var index: Int)
operator fun Counter.plus(increment: Int): Counter {
    return Counter(index + increment)
}
fun casesCounter() {
    val counter = Counter(1)
    val counterPlus = counter + 10
    println(counterPlus)
}

data class Person2(val name:String, val age:Int)

infix fun Person2.grow(years:Int): Person2 {
    return Person2(name, age + years)
}

fun testPerson2Grow() {
    val p2 = Person2("chen", 20)
    println(p2.grow(20))   // 直接调用函数方式
    println(p2 grow 20)           // 中缀表达式调用方式
    // 输出：
    // Person2(name=chen, age=20)

    val abc = "abc"
    println(abc is String)
    println(abc !is String)


}

/**
 * ?. 安全调用符，表示安全调用非空判断
 * ?: Elvis操作符
 */
fun strLength(s: String?): Int{
    return s?.length ?: 0
}

class Person3(private val name: String, private val age: Int, private val gender: Int) {
    override fun toString(): String {
        return "Person(name='$name', age='$age', gender='$gender')"
    }
}

class Person4 {
    lateinit var name: String
    var age: Int = 0
    lateinit var gender: String

    constructor()

    constructor(name: String) : this() {
        this.name = name
    }

    constructor(name: String, age: Int, gender: String) {
        this.name = name
        this.age = age
        this.gender = gender
    }
}

abstract class Shape {
    abstract var width : Double
    abstract var height : Double
    abstract var radius : Double
    abstract fun area() : Double
    fun onClick () {
        println("fun method default final")
    }
}

class Rectangle(override var width: Double, override var height: Double, override var radius: Double) : Shape() {
    override fun area(): Double {
        return height * width
    }
}

class Circle(override var width: Double, override var height: Double, override var radius: Double) : Shape() {
    override fun area(): Double {
        return 3.14 * radius * radius
    }
}

class Triangle(override var width: Double, override var height: Double, override var radius: Double) : Shape() {
    override fun area(): Double {
        return width * height / 2
    }
}

interface ProjectService {
    val name : String
    val owner : String
    fun save()
}

class ProjectServiceImpl(override val name: String, override val owner: String) : ProjectService {
    override fun save() {
        TODO("Not yet implemented")
    }
}

// kotlin 单例
object User {

}

// kotlin 伴生对象, 一个类只能有一个伴生对象
class DataProcessor {
    companion object DataProcessor {
        fun process() {
            println("i'm processing data")
        }
    }
}

data class LoginUser(val username: String, val password: String)

val map = mapOf(1 to "A", 2 to "B", 3 to "C")

// kt 枚举
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    /**
     * val c = Color.GREEN
     * c.rgb   访问 GREEN 枚举的 rgb 参数值
     * c.ordinal   访问 GREEN 枚举的 ordinal 属性
     *
     */
}

// kt 内部类
// kt 普通嵌套类
class NestedClasses {
    class Outer {
        private val zero: Int = 0
        val one: Int = 1
        class Nested {
            fun getTwo() = 2
            class Nested1 {
                val three = 3
                fun getFour() = 4
            }
        }
    }
}

// kt 嵌套内部类, 可直接访问外部类成员
class NestedInnerClasses {
    class Outer {
        private val zero: Int = 0
        val one: Int = 1
        inner class InnerClz {
            fun accessOuterMember() = {
                println(zero)
            }
        }
    }
    // kt 匿名内部类
    class AnonymousInnerClass {
        var isRunning = false
        fun doRun() {
            Thread(object : Runnable {
                override fun run() {
                    TODO("Not yet implemented")
                    isRunning = true
                    println("anonymous inner class is running")
                }
            }).start()
        }

        // lambda 表达式实现
        fun doStop() {
            Thread({
                println("do stop")
            })
        }
        // 使用匿名内部类，使用 lambda 表达式实现 run 接口
        fun doWait() {
            val wait = Runnable {
                println("do wait")
            }
            Thread(wait).start()
        }
    }
}

//kt apply 函数
fun testApply() {
    // 普通list写法
    val list = mutableListOf<String>()
    list.add("A")
    list.add("B")
    list.add("C")
    // 使用 apply 写法
    val a = ArrayList<String>().apply {
        add("A")
        add("B")
        add("C")
    }
    // with 函数写法
    with(ArrayList<String>()) {
        add("A")
        add("B")
        add("C")
    }

}

// 获取字符串首字符
fun String.firstChar():String {
    if (this.isEmpty())return ""
    return this[0].toString();
}

fun duplicateData(list: List<Int>): List<Int> {
    return list.distinct()
}

// kt 泛型















































