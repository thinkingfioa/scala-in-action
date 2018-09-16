package org.lwl.scala.basic.chapter.three

import util.control.Breaks._

/**
  *
  * @author thinking_fioa 2018/9/16
  */

object Ctrl3P5 {

  def main(args: Array[String]): Unit = {
    val array : Array[Int] = (1 to 10).toArray
    forBreak(array)
    println()
    forContinue(array)
  }

  def forBreak(array : Array[Int]) : Unit = {
    breakable {
      for(i <- array) {
        if(i== 2) {
          break()
        } else {
          print(i+", ")
        }
      }
    }
  }

  def forContinue(array : Array[Int]) : Unit = {
    for(i <- array) {
      breakable {
        if(i== 2) {
          break()
        } else {
          print(i +", ")
        }
      }
    }
  }
}
