package org.lwl.scala.basic.chapter.five

/**
  *
  * @author thinking_fioa 2018/10/21
  */

class Connection {
  def connection(timeout : Int = 5000, protocol : String = "http"): Unit = {
    println("timeout = %d, protocol = %s".format(timeout, protocol))
  }
}

object Method5P3 {
  def main(args: Array[String]): Unit = {
    val connection : Connection = new Connection()
    connection.connection()
  }
}
