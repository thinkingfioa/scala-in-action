package org.lwl.scala.basic.chapter.one.impl

/**
  * @author thinking_fioa
  */

import org.lwl.scala.basic.chapter.one.impl.ImplVal.name;
import org.lwl.scala.basic.chapter.one.impl.ImplicitHelper.{ImpAdd, strToInt, echo};

object ImplicitTest {
  def main(args: Array[String]): Unit = {
    println(1.add(2)) // 输出 3

    println(strToInt("1")) // 输出 1

    println(math.max("1", 2)) // 输出 2

    echo("hello")("word") // 输出 hello,word
    echo("hello") // 输出 hello,rey
    //或者像下面这样
    //implicit val impl = "implicit"
    //echo("hello")
  }
}
