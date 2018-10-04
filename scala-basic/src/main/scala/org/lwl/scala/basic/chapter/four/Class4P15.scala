package org.lwl.scala.basic.chapter.four

/**
  *
  * @author thinking_fioa 2018/10/4
  */

class Person4P14(val name : String, val age : Int) {

  def canEqual(a : Any) : Boolean = a.isInstanceOf[Person4P14]

  override def equals(that : Any) : Boolean = that match {
    case that : Person4P14 => this.canEqual(that) && this.hashCode() == that.hashCode()
    case _ => false
  }

  override def hashCode() : Int = {
    // TODO 补充hashCode值
    31
  }
}

object Class4P14 {

}
