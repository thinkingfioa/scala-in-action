package org.lwl.scala.basic.chapter.three

/**
  *
  * @author thinking_fioa 2018/9/16
  */

object Ctrl3P3 {

  def main(args: Array[String]): Unit = {
    forIf()
  }

  def forIf() : Unit = {
    for {
      i <- 1 to 10
      if i> 3
      if i<= 8
      if i % 2 == 0
    } println(i)
  }
}
