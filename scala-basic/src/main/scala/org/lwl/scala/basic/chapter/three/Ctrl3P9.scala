package org.lwl.scala.basic.chapter.three

/**
  *
  * @author thinking_fioa 2018/9/17
  */

object Ctrl3P9 {

  def main(args: Array[String]): Unit = {
    println(isTrue(0))
  }

  def isTrue(a : Any) = a match{
    case 0 | "" => false
    case _ => true
  }
}
