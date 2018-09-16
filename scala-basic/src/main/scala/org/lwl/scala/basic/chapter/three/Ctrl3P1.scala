package org.lwl.scala.basic.chapter.three

/**
  *
  * @author thinking_fioa 2018/9/16
  */

object Ctrl3P1 {

  def main(args: Array[String]): Unit = {
    val array = Array("apple", "banana", "orange")
    // 3.1.1
    forF(array)
    // 3.1.2
    val arrayReturn : Array[String] =forYield(array)
    for( e <- arrayReturn) {
      print(e + ", ")
    }
    println()
    // 3.1.3
    forCount(array)

    // 3.1.4
    val nameMap = Map("thinking" -> 22, "ppp" -> 23)
    forMap(nameMap)

  }

  def forF(array : Array[String]): Unit = {
    for(entry <- array) {
      println(entry.toUpperCase())
    }
  }

  def forYield(array : Array[String]) : Array[String] = {
    for(entry <- array) yield {
      entry.toUpperCase()
    }
  }

  def forCount(array : Array[String]): Unit = {
    for(i <- array.indices) {
      println(s"$i is ${array(i)}")
    }
  }

  def forMap(namesMap : Map[String, Int]) : Unit = {
    for((k,v) <- namesMap) {
      println(s"key is $k, value is $v")
    }
  }

  def printWithComma(str : String): Unit = {
    print(str+", ")
  }
}
