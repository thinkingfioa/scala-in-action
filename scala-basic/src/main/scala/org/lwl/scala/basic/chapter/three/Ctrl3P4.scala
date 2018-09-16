package org.lwl.scala.basic.chapter.three

/**
  *
  * @author thinking_fioa 2018/9/16
  */

object Ctrl3P4 {

  def main(args: Array[String]): Unit = {
    val array = Array("thinking", "fioa", "ppp")
    forYieldMoreLine(array).foreach(println)
  }

  def forYieldMoreLine(array : Array[String]) : Array[Int] = {
    for( e <- array) yield {
      val eUpper = e.toUpperCase()
      eUpper.length
    }
  }
}
