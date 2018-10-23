package org.lwl.scala.basic.chapter.five

import scala.beans.BeanProperty

/**
  *
  * @author thinking_fioa 2018/10/23
  */

class Pizza5P6(@BeanProperty var price : Int, @BeanProperty var size:Int) {

}

object Method5P6 {

  def main(args: Array[String]): Unit = {
    val pizza : Pizza5P6 = new Pizza5P6(100, 12)
    println("price "+pizza.getPrice)
    println("size "+pizza.getSize)
  }
}
