package org.lwl.scala.basic.chapter.one

import scala.util.matching.Regex

/**
  *
  * @author thinking_fioa 2018/9/8
  */

object String1P7 {

  def main(args: Array[String]): Unit = {
    val numPatter = "[0-9]+".r
    val str : String = "123 Main Stree Suit 101"
    firstReg(str, numPatter)
    allReg(str, numPatter)

    findRegAndOption(str, new Regex("[9]+"))
  }

  def firstReg(str: String, numPattern: Regex) : Unit = {
    numPattern.findFirstIn(str).foreach(println)
    println("end of firstReg")
  }

  def allReg(str: String, numPattern : Regex) : Unit = {
    numPattern.findAllIn(str).foreach(println)
    println("end of allReg")
  }

  def findRegAndOption(str: String, numPattern: Regex) : Unit = {
    println(numPattern.findFirstIn(str).getOrElse("no match"))
  }
}
