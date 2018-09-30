package org.lwl.scala.basic.chapter.four

/**
  *
  * @author thinking_fioa 2018/9/30
  */

class Pizza(var crustSize : Int, var crustType : String) {

  def this(crustSize: Int) {
    this(crustSize, Pizza.DEFAULT_CRUST_TYPE)
  }

  override def toString: String = s"Thinking eat Pizza $crustSize, $crustType"
}

object Pizza {
  val DEFAULT_CRUST_SIZE = 12
  val DEFAULT_CRUST_TYPE = "THIN"
}

// 代码清单 4.3.1
case class Person4P2(var name : String, var age : Int)

object Person4P2 {
  def apply(name : String) = new Person4P2(name, 0)
}

object Class4P3 {
  var p : Person4P2 = Person4P2("thinking")
}


