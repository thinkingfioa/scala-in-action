package org.lwl.scala.basic.chapter.one

/**
  * @author thinking_fioa
  */


object String1P1 {
  def main(args: Array[String]): Unit = {
    val s1="thinking"
    val s2="Thinking"

    println(s1==s2) // 输出: false
    println(s1.toUpperCase == s2.toUpperCase) // 输出: true
    println(s1.equalsIgnoreCase(s2)) // 输出: true
  }
}
