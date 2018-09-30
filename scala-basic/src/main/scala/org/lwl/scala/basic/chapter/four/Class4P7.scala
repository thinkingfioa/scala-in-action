package org.lwl.scala.basic.chapter.four

/**
  *
  * @author thinking_fioa 2018/9/30
  */

class Book {
  private[this] var price : Double = _

  def setPrice(price:Double ): Unit = {
    this.price = price
  }

  def isHigher(that : Book): Boolean = {
    // 报错，无法在this对象中访问that对象的price
//    this.price > that.price
    true
  }
}

object Class4P7 {

}
