package org.lwl.scala.basic.chapter.five

/**
  *
  * @author thinking_fioa 2018/10/21
  */

trait Human {
  def hello : String = "the Human trait"
}

trait Mother extends Human {
  override def hello: String = "Mother"
}

trait Father extends Human {
  override def hello: String = "Father"
}

class Child extends Human with Mother with Father {
  def printSupper : String = super.hello
  def printMother : String = super[Mother].hello
  def printFather : String = super[Father].hello
  def printHuman : String = super[Human].hello

  def print(): Unit = {
    println(s"supper $printSupper")
    println(s"Mother $printMother")
    println(s"Father $printFather")
    println(s"Human $printHuman")
  }
}

object Child {
  def apply() = new Child()
}

object Method5P2 {
  def main(args: Array[String]): Unit = {
    val child : Child = Child()
    child.print()
  }
}
