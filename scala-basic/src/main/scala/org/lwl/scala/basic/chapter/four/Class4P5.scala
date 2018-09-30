package org.lwl.scala.basic.chapter.four

/**
  *
  * @author thinking_fioa 2018/9/30
  */

class Socket (val timeout : Int = 1000) {

}

object Class4P5 {

  def main(args: Array[String]): Unit = {
    val socket : Socket = new Socket(timeout = 3000)
  }
}
