package org.lwl.scala.basic.chapter.three

import java.io.{FileInputStream, IOException}

/**
  *
  * @author thinking_fioa 2018/9/23
  */

object Ctrl3P17 {

  def tryCatchFinally(fileName : String) : Unit = {
    var in = None : Option[FileInputStream]

    try {
      // open file Name
    } catch {
      case cause: IOException => cause.printStackTrace()
    } finally {
      if(in.isDefined) {
        in.get.close()
      }
    }
  }
}
