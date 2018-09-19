package org.lwl.scala.basic.chapter.three

import scala.annotation.switch

/**
  *
  * @author thinking_fioa 2018/9/19
  */

object Ctrl3P13 {

  def main(args: Array[String]): Unit = {
    caseIfNum(1)
    caseIfNum(2)
  }

  def caseIfNum(x : Int) : Unit = {
    (x : @switch) match {
      case m if m==1 => println("one, a lonely number")
      case n if n==2 || n==3 => println(n)
      case _ => println("default")
    }

  }
}
