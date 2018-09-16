package org.lwl.scala.basic.chapter.three

/**
  *
  * @author thinking_fioa 2018/9/16
  */

object Ctrl3P2 {

  def main(args: Array[String]): Unit = {
    forMoreCount()
  }

  def forMoreCount() : Unit = {
    for {
      i <- 1 to 3
      j <- 1 to 5
      k <- 1 to 10
    } {
      println("next: ")
      println(s"i : $i, j : $j, k : $k")
    }
  }
}
