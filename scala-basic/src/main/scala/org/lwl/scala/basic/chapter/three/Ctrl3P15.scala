package org.lwl.scala.basic.chapter.three

/**
  *
  * @author thinking_fioa 2018/9/19
  */

object Ctrl3P15 {

  def main(args: Array[String]): Unit = {
    val x = List(1,2,3,4)
    println(caseList(x))
  }

  def caseList(x : List[Int]) : String = x match {
    case s :: rest => s +", " + caseList(rest)
    case Nil => ""
  }
}
