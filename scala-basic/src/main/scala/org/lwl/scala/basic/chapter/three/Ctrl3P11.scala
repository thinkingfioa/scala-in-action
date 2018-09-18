package org.lwl.scala.basic.chapter.three

/**
  *
  * @author thinking_fioa 2018/9/17
  */

trait Animal

case class Dog(name : String) extends Animal

case class Cat(name : String) extends Cat

case object Woodpecker extends Animal

object Ctrl3P11 {

  def main(args: Array[String]): Unit = {

  }

  def determineType(x : Animal) : String = x match {
    case Dog(moniker) => "Got a Dog, name = "+moniker
    case _:Cat => "Got a Cat"
    case Woodpecker => "That was a Wood"
  }

}
