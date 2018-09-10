package org.lwl.scala.basic.chapter.one

import scala.util.matching.Regex

/**
  *
  * @author thinking_fioa 2018/9/9
  */

object String1P8 {

  def main(args: Array[String]): Unit = {
    one("([0-9]+) ([A-Za-z]+)".r, "100 apple")
  }

  def one(pattern : Regex,inputStr : String) : Unit = {
    val pattern(count, fruit) = inputStr
    printf(s"$fruit price is $count")
  }
}
