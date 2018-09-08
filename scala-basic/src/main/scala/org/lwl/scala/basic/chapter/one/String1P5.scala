package org.lwl.scala.basic.chapter.one

/**
  *
  * @author thinking_fioa 2018/9/8
  */

object String1P5 {

  def main(args: Array[String]): Unit = {
    mapStr()
    forStr()
    mapOfMethod()
  }

  def mapStr() : Unit = {
    val upper = "thinking, fioa".filter( _ != 'i').map(_.toUpper)
    println(upper)
  }

  def forStr() : Unit = {
    val upper = for( c <- "thinking, fioa") yield c.toUpper
    println(upper)
  }

  def mapOfMethod() : Unit = {
    val upper = "thinking, fioa".filter( _ != 'i').map(strToUpper)
    println(upper)
  }

  def strToUpper(c : Char) : Char = {
    c.toUpper
  }
}
