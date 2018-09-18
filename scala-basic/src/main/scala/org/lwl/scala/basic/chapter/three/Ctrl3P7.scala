package org.lwl.scala.basic.chapter.three

import scala.annotation.switch

/**
  *
  * @author thinking_fioa 2018/9/17
  */

object Ctrl3P7 {
  def main(args: Array[String]): Unit = {
    println(switchTypo(3))
    println(switchType('c'))
  }

  def switchTypo(i : Int) : String = {
    (i : @switch) match {
      case 1 => "One"
      case 2 => "Two"
      case _ => "Other"
    }
  }

  def switchType(x : Any) : String = {
    (x : @switch) match {
      case s : String => "One"
      case i : Int => "Two"
      case default => {println(s"$default is other"); "luweilin"}
    }
  }
}
