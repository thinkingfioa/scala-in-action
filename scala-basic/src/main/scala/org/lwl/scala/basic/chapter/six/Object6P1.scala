package org.lwl.scala.basic.chapter.six

/**
  *
  * @author thinking_fioa 2018/11/6
  */

object Object6P1 {

  def main(args: Array[String]): Unit = {
    val a = 10
    val b = a.asInstanceOf[Long]
    println(b.getClass)
  }
}
