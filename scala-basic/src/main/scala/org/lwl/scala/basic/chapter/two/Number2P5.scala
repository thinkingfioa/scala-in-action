package org.lwl.scala.basic.chapter.two

/**
  *
  * @author thinking_fioa 2018/9/12
  */

object Number2P5 {

  def main(args: Array[String]): Unit = {

    val d3 = 0.3d
    val addDouble : Double = sumDouble(0.2d, 0.1d)
    println(s" $d3 != $addDouble")

    println(~=(d3, addDouble, 0.000001))
  }

  /**
    * 输出 0.30000000000000004
    */
  def sumDouble(d1 : Double, d2 : Double) : Double = {
    d1 + d2
  }

  def ~=(x: Double, y:Double, precision: Double): Boolean = {
    if((x-y).abs < precision) {
      true
    } else {
      false
    }
  }
}
