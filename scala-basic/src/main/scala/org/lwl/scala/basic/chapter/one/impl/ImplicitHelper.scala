package org.lwl.scala.basic.chapter.one.impl

/**
  * @author thinking_fioa
  */


object ImplVal {
  implicit val name: String="reynold1"
}

/**
  * 定义trait，允许别人继承。类似于Java的interface
  */
//trait ImplVal {
//  implicit val name: String="reynold2"
//}

object ImplicitHelper {

  def echo(param: String)(implicit impl: String): Unit = {
    println(param + "," +impl);
  }

  /**
    * 隐式转换函数是指在同一个作用域下面，一个给定输入类型并自动转换为指定返回类型的函数，
    * 这个函数和函数名字无关，和入参名字无关，只和入参类型以及返回类型有关
    * @param str
    * @return
    */
  implicit def strToInt(str: String) = {
    str.toInt
  }

  /**
    *  隐式类的主构造函数参数有且仅有一个！之所以只能有一个参数，
    */
  implicit class ImpAdd(origin: Int) {
    def add(param: Int) = origin + param;
  }
}
