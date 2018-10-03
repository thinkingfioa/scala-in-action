package org.lwl.scala.basic.chapter.four

/**
  *
  * @author thinking_fioa 2018/10/3
  */

case class Person4P9(var userName : String, var passwd : String) {
  var age : Int = 0
  var address: Option[Address] = None : Option[Address]

}

case class Address(var city : String, var state : String) {
  override def toString: String = s"$state in $city"
}

object Class4P9 {

  def main(args: Array[String]): Unit = {
    var person : Person4P9 = Person4P9("thinking", "fioa")
    person.address = Some(Address("beijin", "nanjinRoad"))

    person.address.foreach { a => {
        println(a.city)
        println(a.state)
      }
    }
  }
}
