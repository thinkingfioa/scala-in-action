package org.lwl.scala.basic.chapter.one

/**
  *
  * @author thinking_fioa 2018/9/10
  */

object String1P9 {

  private val str : String = "thinking_fioa"

  def main(args: Array[String]): Unit = {
    println(s"charAt: ${str.charAt(7)}")
    println(s"scala(): ${str(4)}")
  }
}
