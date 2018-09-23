package org.lwl.scala.basic.chapter.three

import scala.annotation.tailrec

/**
  *
  * @author thinking_fioa 2018/9/23
  */

object Ctrl3P18 {

  def main(args: Array[String]): Unit = {
    var i =0
    whilst(i<5) {
      println(s"index: $i")
      i += 1
    }
  }

  @tailrec
  def whilst(testCondition : => Boolean) (codeBlock : => Unit) {
    if(testCondition) {
      codeBlock
      whilst(testCondition)(codeBlock)
    }
  }
}
