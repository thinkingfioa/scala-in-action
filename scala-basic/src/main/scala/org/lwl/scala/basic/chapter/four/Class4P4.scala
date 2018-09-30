package org.lwl.scala.basic.chapter.four

/**
  *
  * @author thinking_fioa 2018/9/30
  */

class Brain private (var name : String, var speed : Long) {

  override def toString: String = s"$name have $speed ms"

  def printBrain() : Unit = {
    print(toString())
  }
}

object Brain {
  val brain = new Brain("thinking", 1)
  def getIntance: Brain = brain
}

object Class4P4 {
  def main(args: Array[String]): Unit = {
    Brain.getIntance.printBrain()
  }
}
