package org.lwl.scala.basic.chapter.four

/**
  *
  * @author thinking_fioa 2018/10/3
  */

class FooTest {

  var text = {
    var lineText="unkonw text"
    try {
      lineText = "try code"
    } catch {
      case e : Exception => lineText = "catch code"
    }

    lineText
  }
}

object Class4P8 {

  def main(args: Array[String]): Unit = {
    val fooTest : FooTest = new FooTest()
//    println(fooTest.text)
  }
}
