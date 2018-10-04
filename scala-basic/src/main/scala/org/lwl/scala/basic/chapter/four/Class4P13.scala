package org.lwl.scala.basic.chapter.four

/**
  *
  * @author thinking_fioa 2018/10/4
  */

abstract class Animal4P13 {
  var greeting : String = "Hello"
  val age : Int = 0

  val sayHello: Unit = {println(s"Animal4P13, say $greeting")}
}

class Dog4P13 extends Animal4P13 {
  greeting = "Dog"

  override val sayHello: Unit = {println(s"Dog4P13, say $greeting")}
}

object Class4P13 {

  def main(args: Array[String]): Unit = {
    val dog : Dog4P13 = new Dog4P13()
  }
}
