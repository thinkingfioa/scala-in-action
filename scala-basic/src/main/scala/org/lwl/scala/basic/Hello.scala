package org.lwl.scala.basic

/**
  * @author thinking_fioa 2018/8/29
  */


object Hello {

  def main(args: Array[String]): Unit = {
    print(sayHello("thiking"));
  }

  def sayHello(x: String): String = {
    return "hello," + x;
  }
}
