package org.lwl.scala.basic.chapter.three

/**
  *
  * @author thinking_fioa 2018/9/17
  */

trait Animal

case class Dog(name : String) extends Animal

case class Cat(name : String) extends Animal

case object Woodpecker extends Animal

object Ctrl3P11 {

  def main(args: Array[String]): Unit = {
    println(determineType(Dog("ppp")))
    println(determineType(Cat("fioa")))
    println(determineType(Woodpecker))
  }

  def determineType(x : Animal) : String = x match {
    case Dog(moniker) => "Got a Dog, name = "+moniker
    case _ : Cat => "Got a Cat"
    case Woodpecker => "That was a Wood"
    case _ => "default"
  }

}
