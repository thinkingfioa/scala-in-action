package org.lwl.scala.basic.chapter.one

/**
  * @author thinking_fioa
  */


object String1P3 {

  def main(args: Array[String]): Unit = {
    val str : String = "thinking, fioa, lu ppp"
    val strArray : Array[String] = splitStr(str)
    strArray.foreach(println)
  }

  def splitStr(str: String) : Array[String] = {
    val strArray: Array[String] = str.split("\\s+").map(_.trim)
    strArray
  }
}
