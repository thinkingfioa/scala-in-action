package org.lwl.scala.basic.chapter.one

/**
  * @author thinking_fioa
  */


object String1P4 {

  def main(args: Array[String]): Unit = {
    strOfS()
    strOfF()
    strOfRaw()
  }

  def strOfS() : Unit = {
    val name : String = "thinking"
    val age : Int = 23

    println(s"$name is $age years old")
    println(s"Age next year: ${age +1}")
  }

  def strOfF() : Unit = {
    val weight : Double = 120

    println(f"my weight is $weight%.2f")
  }

  def strOfRaw() : Unit = {
    val str = raw"thinking\nppp"
    println(str)
  }

}
