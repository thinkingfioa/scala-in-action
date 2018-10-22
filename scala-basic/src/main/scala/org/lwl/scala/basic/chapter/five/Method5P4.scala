package org.lwl.scala.basic.chapter.five

/**
  *
  * @author thinking_fioa 2018/10/22
  */

class Pizza {
  var size = 12
  var price = 200

  def update(currSize : Int, currPrice : Int) : Unit = {
    this.size = currSize
    this.price = currPrice
  }

  def print() : Unit = {
    println(s"size $size, price $price")
  }
}

object Method5P4 {

  def main(args: Array[String]): Unit = {
    var pizza : Pizza = new Pizza()
    pizza.update(currSize = 15, currPrice = 100)
    pizza.print()
  }
}
