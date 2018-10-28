package org.lwl.scala.basic.chapter.five

/**
  *
  * @author thinking_fioa 2018/10/28
  */


class Person5P9 {
  protected var fname = ""
  protected var lname = ""

  def setFirstName(firstName : String) : this.type = {
    this.fname = firstName
    this
  }

  def setLastName(lastName : String) : this.type = {
    this.lname = lastName
    this
  }
}

class Employee extends Person5P9 {
  protected var role = ""

  def setRole(role : String) : this.type  = {
    this.role = role
    this
  }
}
object Method5P9_1 {

}
