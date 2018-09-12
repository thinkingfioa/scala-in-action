# scala-basic 基础篇

```
@author 鲁伟林
Scala基础知识介绍，主要包括《Scala编程实战》的基础章节

GitHub地址: https://github.com/thinkingfioa/scala-in-action
本人博客地址: http://blog.csdn.net/thinking_fioa/article/details/78265745
```

# 第1章 字符串
 [第1章项目源码阅读](https://github.com/thinkingfioa/scala-in-action/tree/master/scala-basic/src/main/scala/org/lwl/scala/basic/chapter/one)

## 1. 引言
初一看Scala的String和Java的String并没有什么区别，基本上Java的String所具有的属性Scala的String都具有。另一方面，由于Scala提供了隐式转换的魔法，Scala的String同时还拥有StringOps类、StringLike类WrappedString等方法。

下列是Scala的String常具有的方法

```
1. "hello".foreach(println). 
2. for(c <- "hello") println(c)
3. "hello".getBytes.foreach(println)
4. var result = "hello world".filter(_ != 'l')
```

#### Scala隐式转换的理解
Scala隐式转换是一种非常强大的代码查找机制。通过隐式转换，程序员可以在编写Scala程序时故意遗漏一些信息，让编译器去尝试在编译期间自动推导出这些信息，减少冗长代码。

简单的说，隐式转换就是：当Scala编译器进行类型匹配时，如果找不到合适的候选，那么隐式转化提供了另一种途径来告诉编译器如何将当前的类型转换成预期类型

使用方式:

1. 将方法或变量标记为implicit 
2. 将方法的参数列表标记为implicit
3. 将类标记为implicit
4. 参考例子：*.chapter.one.impl.{ImplicitHelper, ImplicitTest}

##### 代码:
```
package org.lwl.scala.basic.chapter.one.impl

object ImplVal {
  implicit val name: String="reynold1"
}

object ImplicitHelper {

  def echo(param: String)(implicit impl: String): Unit = {
    println(param + "," +impl);
  }

  /**
    * 这个函数和函数名字无关，和入参名字无关，只和入参类型以及返回类型有关
    */
  implicit def strToInt(str: String) = {
    str.toInt
  }

 /**
    *  隐式类的主构造函数参数有且仅有一个！之所以只能有一个参数，
    */
  implicit class ImpAdd(origin: Int) {
    def add(param: Int) = origin + param;
  }
}
```

### 1.1 测试字符串的相等性

1. 比较两个字符串相等, eg: s1 == s2。不会抛出NPE异常
2. 不考虑字符大小写问题比较, eg: s1.toUpperCase == s2.toUpperCase。需要处理抛出NPE异常
3. 使用Java的字符串类, eg: s1.equalsIgnoreCase(b)

##### 代码:
```
object String1P1 {
  def main(args: Array[String]): Unit = {
    val s1="thinking"
    val s2="Thinking"

    println(s1==s2) // 输出: false
    println(s1.toUpperCase == s2.toUpperCase) // 输出: true
    println(s1.equalsIgnoreCase(s2)) // 输出: true
  }
}
```

### 1.2 创建多行字符串
Scala使用三个双引号创建多行字符串

1. 多行字符串，所见即所得。也就是，你在代码中怎么写，输出就是什么样
2. 使用特殊字符+stripMargin，达到多行字符串都是顶格写
3. 多行字符串单行显示， """moreLineStr""".stripMargin.replaceAll("\n", " ")
4. 多行字符串语法中允许写单引号和双引号，无需转义

##### 代码:
```
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
```

### 1.3 分割字符串
使用split("...")分割一个字符串。split支持使用正则表达式，eg： str.split("\\s+")

##### 代码:
```
object String1P3 {

  def main(args: Array[String]): Unit = {
    val str : String = "thinking, fioa, lu ppp"
    val strArray : Array[String] = splitStr(str)
    strArray.foreach(println)
  }

  def splitStr(str: String) : Array[String] = {
    val strArray: Array[String] = str.split("\\s+").map(_.trim)
    strArray
  }
}
```

### 1.4 字符串中的变量代换
在字符串中引用变量的值

#### 1.4.1 字符串插值 - 字符串前加字母's'
在每个字符串前的's'实际上是一个方法

- $variable ----- println(s"Age is $age")
- 使用表达式 ----- println(s"Age next year: ${age + 1}")

#### 1.4.2 字符串插值 - 字符串前加字母'f'
在字符串前加字母'f'，格式化内部字符串。eg: val out = f"$name, you weight $weight%.2f pounds."

#### 1.4.3 字符串插值 - 字符串前加字母raw
raw插入符"不会对字符串中的字符进行转义"

##### 代码:
```
object String1P4 {

  def main(args: Array[String]): Unit = {
    strOfS()
    strOfF()
    strOfRaw()
  }

  def strOfS() : Unit = {
    val name : String = "thinking"
    val age : Int = 23

    println(s"$name is $age years old")
    println(s"Age next year: ${age +1}")
  }

  def strOfF() : Unit = {
    val weight : Double = 120

    println(f"my weight is $weight%.2f")
  }

  def strOfRaw() : Unit = {
    val str = raw"thinking\nppp"
    println(str)
  }
}
```

### 1.5 挨个处理字符串中的字符
遍历字符串中的每个字符，在遍历的同时对字符串做些操作。可以使用map、foreach方法、for循环来遍历集合

#### 1.5.1 map
对于字符串字符序列集合，先使用filter过滤单个字符，然后调用map方法处理每个字符. eg: val upper = "thinking, fioa".filter(_ != 'i').map(_.toUpper)

#### 1.5.2 使用for + yield语句实现1.5.1中的效果
在for循环添加yield实际上将每次循环的结果放入一个临时存放区。等循环结束后，以集合的形式返回. eg: val upper = for(c <- "thinking, fioa") yield c.toUpper

#### 1.5.3 传入函数到map中
可以给map方法传入一个大的代码块. eg: val upper = "thinking, fioa".filter( _ != 'i').map(strToUpper)

#### 1.5.4 foreach方法
使用foreach方法操作每个Byte值. eg: "hello".getBytes.foreach(println)

##### 代码:
```
object String1P5 {

  def main(args: Array[String]): Unit = {
    mapStr()
    forStr()
    mapOfMethod()
  }

  def mapStr() : Unit = {
    val upper = "thinking, fioa".filter( _ != 'i').map(_.toUpper);
    println(upper)
  }

  def forStr() : Unit = {
    val upper = for( c <- "thinking, fioa") yield c.toUpper
    println(upper)
  }
  
  def mapOfMethod() : Unit = {
    val upper = "thinking, fioa".filter( _ != 'i').map(strToUpper)
    println(upper)
  }

  def strToUpper(c : Char) : Char = {
    c.toUpper
  }
}
```

### 1.6 字符串中的查找模式
判断一个字符串是否符合一个正则表达式

#### 1.6.1 创建Regex对象
1. 在一个String上调用.r方法可以创建一个Regex对象. val numPattern = "[0-9]+".r
2. 创建Regex实例. val numPattern = new Regex("[0-9]+")

#### 1.6.2 查找匹配方法： findFirstIn(含有一个匹配) + findAllIn(全部匹配)
- findFirstIn方法返回一个Option[String]。可以使用Option类中的getOrElse方法，这个将在20.6节介绍更多内容
- findAllIn方法返回一个迭代器，可以直接使用foreach方法遍历。或者toArray方法转换成Array数组

##### 代码:
```
object String1P6 {

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
```

### 1.7 字符串中的替换模式
使用正则表达式匹配一段字符串，然后替换它们。注意,String是不可变的，请一定记得把结果赋给一个新的变量

#### 1.7.1 使用String类的方法
- replaceAll ----- 替换所有匹配的字符串. eg: val result = "123".replaceAll("[0-9]", "x")
- replaceFirst ----- 替换第一个匹配的字符串. eg: val result = "123".replaceFirst("[0-9]", "x")

#### 1.7.2 使用正则表达式的方法
- replaceAllIn ----- 替换所有匹配的字符串. eg: val result = regex.replaceAllIn("123 Main Street", "x")
- replaceFirstIn ----- 替换第一个匹配的字符串. eg: val result = regex.replaceAll("Hello world", "J")

##### 代码:
```
object String1P6 {

  val originStr : String = "123 Main Street 456"

  def main(args: Array[String]): Unit = {
    val return1 = replaceOfString(originStr)
    println(s"return 1 is ${return1._1}, return 2 is ${return1._2} ")

    val return2 = replaceOfRegex("[0-9]+".r)
    println(s"return 1 is ${return2._1}, return 2 is ${return2._2} ")
  }

  private def replaceOfString(str : String) : (String, String) = {
    val allStr : String = str.replaceAll("[0-9]+", "x")
    val firstStr : String = str.replaceFirst("[0-9]+", "x")
    (allStr, firstStr)
  }

  private def replaceOfRegex(regex : Regex) : (String, String) = {
    val allStr : String = regex.replaceAllIn(originStr, "x")
    val firstStr : String = regex.replaceFirstIn(originStr, "x")
    (allStr, firstStr)
  }
}
```

### 1.8 抽取String中模式匹配部分
抽取一个或者多个在字符串中正则匹配到的部分

#### 1.8.1 简单匹配
定义想要抽取的正则表达式，在它们周围加上括号. eg: val pattern = "([0-9]+) ([A-Za-z]+)".r

#### 1.8.2 复杂匹配
通常，可能定义多个正则表达式，用于处理不管用户输入什么，都可以匹配到，所以使用到match-case语法。具体将在3.7节学习

##### 代码:
```
object String1P8 {

  def main(args: Array[String]): Unit = {
    one("([0-9]+) ([A-Za-z]+)".r, "100 apple")
  }

  def one(pattern : Regex,inputStr : String) : Unit = {
    val pattern(count, fruit) = inputStr
    printf(s"$fruit price is $count")
  }
}
```

### 1.9 访问字符串中的一个字符
得到字符串中指定位置的一个字符

- 使用Java中的charAt方法 ----- "hello".charAt(0)
- 使用Scala中的Array符号 ----- "hello"(0)

### 1.10 在String类中添加自定义的方法
在Scala 2.10以后，通过定义一个隐式转换的类，在类里定义一些方法，以实现添加自定义的方法。注意：隐式转换类必须定义在一个类或者对象或者包的内部。请给声明自定义方法时，加上返回类型

##### 代码:
```
object String1P10 {

  def main(args: Array[String]): Unit = {
    println("ABCDEFT".increment)
    println("  ".asBoolean.toString)
  }

  implicit class StringImprovements(val str: String) {
    def increment : String = str.map(c => (c+1).toChar)
    def asBoolean : Boolean = str match  {
      case "0" | "zero" | "" | " " => false
      case _ => true
    }
  }
}
```

#### 讨论
隐式转换最大的好处就是：不需要继承自一个现有的类再去添加新的功能。例如，没有必要去创建继承自String类叫作MyString的新类。其工作原理:

1. 编译器找到一个"ABCDEFT"的字符串常量
2. 编译器发现要在String上调用increment方法
3. 因为编译器在String类中找不到可调用的方法，于是开始在当前范围内搜索一个接收String作为参数的隐式转换
4. 编译器找到StringImprovements类，并在这个类中找到increment方法

## 第2章 数值
 [第2章项目源码阅读](https://github.com/thinkingfioa/scala-in-action/tree/master/scala-basic/src/main/scala/org/lwl/scala/basic/chapter/two)
 
### 引言
Scala所有的数值都是对象，包括Byte、Char、Double、Float、Int、Long和Short。其数值类型范围与Java的基本数据类型范围相同。

### 2.1 从字符串到数值
把一个字符串转换成一个Scala的数值类型。

- 使用String的to*方法。eg: val age : Int = "19".toInt
- BigInt和BigDecimal类型的数值也可以通过字符串创建。eg: val b : BigDecimal = BigDecimal("3.1415926")
- String中的toInt方法不支持传入进制，所以采用java.lang.Integer类的parseInt方法。 eg: Integer.parseInt("10", 2);

##### 代码:
```
object Number2P1 {

  def main(args: Array[String]): Unit = {

    val str : String = "111"

    val num : Int = str.toInt
    println(num)

    println(str.toInt2(2))
    println(Integer.parseInt(str, 2))

  }

  implicit class StringToInt(str: String) {
   def toInt2(radix : Int) : Int = Integer.parseInt(str, radix)
  }
}
```

### 2.2 数值类型转换
把一个数值类型转换成另一种数值类型，如把Int类型转换成Double类型。在Scala中，不可以直接进行强制类型转换，使用在所有数值类型上都可用的to*方法。eg: 19.45.toInt

- 为了避免类型转换可能出现错误，在转换前可以使用相应的isValid方法确认是否可以进行类型转换。eg: a.isValidShort

### 2.3 重载默认数值类型
对一个数值类型变量赋值时，Scala会自动把数值类型赋值给变量. eg: val a =1d, a的类型则是Double。另一个方案是:  val b = 0: Double, b的类型则是Double

### 2.4 替代 ++ 和 --
像其他语言里那样使用++和--来递增或者递减一个变量，但是Scala里没有这样的操作符。需要使用+=、-=、*=和/=方法来实现递增。eg:  a +=1 

### 2.5 浮点数的比较
比较两个浮点数的值，与其他语言一样，两个应该相等的浮点数有可能实际上是不等的

##### 代码:
```
object Number2P5 {

  def main(args: Array[String]): Unit = {
    val d3 = 0.3d
    val addDouble : Double = sumDouble(0.2d, 0.1d)
    println(s" $d3 != $addDouble")
    println(~=(d3, addDouble, 0.000001))
  }

  /**
    * 输出 0.30000000000000004
    */
  def sumDouble(d1 : Double, d2 : Double) : Double = {
    d1 + d2
  }

  def ~=(x: Double, y:Double, precision: Double): Boolean = {
    if((x-y).abs < precision) {
      true
    } else {
      false
    }
  }
}
```

### 2.6 处理大数
需要编写一个处理非常大的整数的程序





























