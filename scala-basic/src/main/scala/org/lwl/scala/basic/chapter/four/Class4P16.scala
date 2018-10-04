package org.lwl.scala.basic.chapter.four

/**
  * Scala内部类从属于外部类对象的
  *
  * @author thinking_fioa 2018/10/4
  */

class OuterClass {
  class InnerClass {
    var x = 1
  }

  object InnerObject {
    val y = 2
  }
}

object OuterObject {
  class InnerClass {
    var m =3
  }

  object InnerObject {
    var n = 4
  }
}

object Class4P16 {

  //调用外部类中的内部类
  val oc = new OuterClass
  var ic = new oc.InnerClass
  println(ic.x)

  //调用外部类中的内部类对象
  println(new OuterClass().InnerObject.y)

  //调用外部对象的内部类
  println((new OuterObject.InnerClass).m)

  //调用外部对象的内部对象
  println(OuterObject.InnerObject.n)
}
