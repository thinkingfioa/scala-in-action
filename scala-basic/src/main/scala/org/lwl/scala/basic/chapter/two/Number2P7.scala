package org.lwl.scala.basic.chapter.two

import scala.util.Random

/**
  *
  * @author thinking_fioa 2018/9/13
  */

object Number2P7 {

  def main(args: Array[String]): Unit = {
    println(random(100))

    randomMore(6)
  }

  def random(upper : Int) : Int = {
    val random = new Random()
    random.nextInt(upper)
  }

  def randomMore(count : Int) : Unit = {
    val random = new Random(System.currentTimeMillis())
    for(i <- 1 to 10) yield println(random.nextInt(100))
  }
}
