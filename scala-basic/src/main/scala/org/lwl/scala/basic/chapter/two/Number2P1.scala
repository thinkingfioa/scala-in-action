package org.lwl.scala.basic.chapter.two

/**
  *
  * @author thinking_fioa 2018/9/11
  */

object Number2P1 {

  def main(args: Array[String]): Unit = {

    val str : String = "111"

    val num : Int = str.toInt
    println(num)

    println(str.toInt2(2))
    println(Integer.parseInt(str, 2))

  }

  implicit class StringToInt(str: String) {
   def toInt2(radix : Int) : Int = Integer.parseInt(str, radix)
  }
}
