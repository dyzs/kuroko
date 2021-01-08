package com.dyzs.kuroko


fun main() {

    DataProcessor.process()

    val loginUser = LoginUser("admin", "12345")
    val (username, password) = loginUser
    println("username = ${username}, password = ${password}")


    val colorGreen = Color.GREEN;
    println("color value = ${colorGreen.ordinal}")

    val one = NestedClasses.Outer().one
    val two = NestedClasses.Outer.Nested().getTwo()
    val three = NestedClasses.Outer.Nested.Nested1().three
    val four = NestedClasses.Outer.Nested.Nested1().getFour()
    println("1 = ${one}")
    println("2 = ${two}")
    println("3 = ${three}")
    println("4 = ${four}")
    val list = listOf(1, 2, 3, 5, 4,4,4,4,4,5);
    println("list res:${list}")
    println("list dup:${duplicateData(list)}")
}