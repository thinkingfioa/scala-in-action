package org.lwl.scala.basic.chapter.one

/**
  * @author thinking_fioa
  */


object String1P2 {

  def main(args: Array[String]): Unit = {
    val moreStr = moreLineStr
    println(moreStr)

    val oneStr = singleLine
    println(oneStr)
  }

  def moreLineStr : String = {
     """ thinking_fioa
      | luweilin"""".stripMargin

  }

  def singleLine : String = {
    """" "thinking_fiao"
      | 'luweilin'""".stripMargin.replace("\n", "")
  }

}
