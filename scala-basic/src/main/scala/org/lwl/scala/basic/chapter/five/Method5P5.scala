package org.lwl.scala.basic.chapter.five

/**
  *
  * @author thinking_fioa 2018/10/23
  */

class MoreReturnValue() {

  def fetchMoreReturn() : (String, Int, Int) = {
    ("thinking", 23, 125)
  }
}

object Method5P5 {

  def main(args: Array[String]): Unit = {
    val moreReturnValue : MoreReturnValue = new MoreReturnValue()
    val (name, age, weight) = moreReturnValue.fetchMoreReturn()
    println(s"name is $name, age is $age, weight is $weight")
  }
}
