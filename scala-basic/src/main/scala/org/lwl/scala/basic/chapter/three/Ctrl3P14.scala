package org.lwl.scala.basic.chapter.three

/**
  *
  * @author thinking_fioa 2018/9/19
  */

trait SentientBeing

trait Animal2 extends SentientBeing

case class Pig(name : String) extends Animal2

case class Person(name:String, age : Int) extends SentientBeing

object Ctrl3P14 {

  def main(args: Array[String]): Unit = {
    casePrintInfo(Person("luweilin", 24))
    casePrintInfo(Pig("ppp"))

    if(Pig("ppp").isInstanceOf[SentientBeing]) {
      println("true")
    }
  }


  def casePrintInfo(x : SentientBeing) : Unit = x match {
    case Person(name, age) => println(s"$name is $name, age is $age")
    case Pig(name) => println(s"pig name is $name")
    case _ => println("default")
  }
}
