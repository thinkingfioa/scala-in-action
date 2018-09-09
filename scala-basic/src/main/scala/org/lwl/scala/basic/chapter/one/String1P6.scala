package org.lwl.scala.basic.chapter.one

import scala.util.matching.Regex

/**
  *
  * @author thinking_fioa 2018/9/9
  */

object String1P6 {

  val originStr : String = "123 Main Street 456"

  def main(args: Array[String]): Unit = {
    val return1 = replaceOfString(originStr)
    println(s"return 1 is ${return1._1}, return 2 is ${return1._2} ")

    val return2 = replaceOfRegex("[0-9]+".r)
    println(s"return 1 is ${return2._1}, return 2 is ${return2._2} ")
  }

  private def replaceOfString(str : String) : (String, String) = {
    val allStr : String = str.replaceAll("[0-9]+", "x")
    val firstStr : String = str.replaceFirst("[0-9]+", "x")
    (allStr, firstStr)
  }

  private def replaceOfRegex(regex : Regex) : (String, String) = {
    val allStr : String = regex.replaceAllIn(originStr, "x")
    val firstStr : String = regex.replaceFirstIn(originStr, "x")
    (allStr, firstStr)
  }
}
