
package org.lwl.scala.basic.chapter.two

/**
  *
  * @author thinking_fioa 2018/9/16
  */

object Number2P8 {

  def main(args: Array[String]): Unit = {
    // 输出: 10,000,000
    System.out.println(printF(10000000))
  }

  def printF(money : Long ) : String = {
    val formatter = java.text.NumberFormat.getIntegerInstance()
    formatter.format(money)
  }
}
