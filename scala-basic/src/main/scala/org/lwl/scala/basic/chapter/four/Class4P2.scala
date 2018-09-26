package org.lwl.scala.basic.chapter.four

/**
  *
  * @author thinking_fioa 2018/9/26
  */

class OtherPerson(name :String) {

}

case class CasePerson(name : String) {

}

object Class4P2 {
  val otherPerson : OtherPerson = new OtherPerson("fioa")
  val casePerson : CasePerson = CasePerson("ppp")

//  println(s"otherPerson ${otherPerson.name}") 报错
  println(s"casePerson ${casePerson.name}")
}
