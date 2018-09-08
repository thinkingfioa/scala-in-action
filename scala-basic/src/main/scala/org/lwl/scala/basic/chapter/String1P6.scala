package org.lwl.scala.basic.chapter

import scala.util.matching.Regex

/**
  *
  * @author thinking_fioa 2018/9/8
  */

object String1P6 {

  def main(args: Array[String]): Unit = {
    val numPatter = "[0-9]+".r
    val str : String = "123 Main Stree Suit 101"
    firstReg(str, numPatter)
    allReg(str, numPatter)
  }

  def firstReg(str: String, numPattern: Regex) : Unit = {
    numPattern.findFirstIn(str).foreach(println)
    println("end of firstReg")
  }

  def allReg(str: String, numPattern : Regex) : Unit = {
    numPattern.findAllIn(str).foreach(println)
  }
}
