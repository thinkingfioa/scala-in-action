package org.lwl.scala.basic.chapter.four

/**
  *
  * @author thinking_fioa 2018/9/30
  */

class Stock(var _symbol : String) {
  def symbol() : String = _symbol

  def symbol_ (s :String) : Unit =  {
    this._symbol = symbol
  }
}

object Class4P6 {

}
