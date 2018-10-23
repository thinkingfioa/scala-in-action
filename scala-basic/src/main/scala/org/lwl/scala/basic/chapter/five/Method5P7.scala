package org.lwl.scala.basic.chapter.five

/**
  *
  * @author thinking_fioa 2018/10/23
  */

class Method5P7 {
  def printAll(strings : String*): Unit = {
    strings.foreach(println)
  }
}

object Method5P7 {
  def main(args: Array[String]): Unit = {
    val method : Method5P7 = new Method5P7()

    method.printAll("thinking", "fioa", "ppp")
    val fruits = List("apple", "apple2")
    method.printAll(fruits : _*)
  }
}
