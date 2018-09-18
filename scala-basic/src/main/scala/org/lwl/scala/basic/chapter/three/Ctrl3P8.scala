package org.lwl.scala.basic.chapter.three

import scala.annotation.switch

/**
  *
  * @author thinking_fioa 2018/9/17
  */

object Ctrl3P8 {
  def main(args: Array[String]): Unit = {
    moreCase(4)
    moreCase(7)
  }

  def moreCase(x : Int) : Unit = {
    (x : @switch) match {
      case 1 | 3 | 5 | 7 | 9 => println("odd")
      case 2 | 4 | 6 | 8 | 10 => println("even")
    }
  }
}
