package com.dyzs.kuroko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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








