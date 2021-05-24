package com.playlab.instaland

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {

    class Test {
        var size: Int = 0
        val isEmpty: Boolean get() {
            println("Acesssando isempty")
            this.size += 1
            return size == 0
        }

        fun setSize(){
            this.size +=1
        }
    }

    val a = Test()
    println(a.isEmpty)
    println(a.isEmpty)

    println(a.size)

}