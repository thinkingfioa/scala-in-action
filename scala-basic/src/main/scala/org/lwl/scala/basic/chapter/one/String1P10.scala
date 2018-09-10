package org.lwl.scala.basic.chapter.one

/**
  *
  * @author thinking_fioa 2018/9/10
  */

object String1P10 {

  def main(args: Array[String]): Unit = {
    println("ABCDEFT".increment)
    println("  ".asBoolean.toString)
  }

  implicit class StringImprovements(val str: String) {
    def increment : String = str.map(c => (c+1).toChar)
    def asBoolean : Boolean = str match  {
      case "0" | "zero" | "" | " " => false
      case _ => true
    }
  }
}
