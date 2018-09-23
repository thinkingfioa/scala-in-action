package org.lwl.scala.basic.chapter.three

import java.io.{FileNotFoundException, IOException}

/**
  *
  * @author thinking_fioa 2018/9/23
  */

object Ctrl3P16 {

  def main(args: Array[String]): Unit = {

  }

  def moreException(fileName : String) : Unit = {
    try {
      // read config File
    } catch {
      case e : FileNotFoundException => println("Colud find that file.")
      case e : IOException => println("Had an IOException trying to read that file")
    }
  }

  @throws(classOf[NumberFormatException])
  def throwException(fileName : String) : Unit = {
    try {
      // read config File
    } catch {
      case e : NumberFormatException => throw e
    }
  }

}
