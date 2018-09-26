package org.lwl.scala.basic.chapter.four

/**
  *
  * @author thinking_fioa 2018/9/26
  */

class Person(var firstName : String, var lastName : String) {
  println("the constructor begins")

  // some class field
  private val HOME = System.getProperty("user.name")
  var age = 0

  override def toString: String = s"$firstName $lastName is $age years old"

  def printHome(): Unit = {
    println(s"HOME = $HOME")
  }

  printHome()
}

object Class4P1 {

  def main(args: Array[String]): Unit = {
    var person : Person = new Person("fioa", "thinking")
  }
}
