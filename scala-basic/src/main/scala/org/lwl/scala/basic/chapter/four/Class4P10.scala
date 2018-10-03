package org.lwl.scala.basic.chapter.four

/**
  *
  * @author thinking_fioa 2018/10/3
  */

class Person4P11(var name : String , var age : Int) {
  override def toString: String = s"name is $name, age is $age"
}

class Employee(name : String, age : Int, var address : Address) extends Person4P11(name, age){
  override def toString: String = s"name is $name, age is $age, address is $address"
}

object Class4P10 {
  def main(args: Array[String]): Unit = {
    val employee : Employee  = new Employee("ppp", 26, Address("Anhui", "anqin"))
    println(employee)
  }
}
