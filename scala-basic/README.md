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

- 为了避免类型转换可能出现错误，在转换前可以使用相应的isValid方法确认是否可以进行类型转换。eg: a.isValidShort，如果超过了数值类型，也会返回false

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
编写一个处理非常大的整数的程序，在Scala语言中可以使用BigInt和BigDecimal类。eg: var b = BigDecimal(123456789.12345678)

### 2.7 生成随机数
使用Scala的Scala.util.Random生成随机数. eg: val random = new Random()

- random.nextInt ----- 返回一个Int范围的随机数
- random.nextInt(100) ----- 返回一个0到99的随机数
- random.nextFloat ----- 返回一个0.0 到 1.0的随机数

##### 代码:
```
object Number2P7 {

  def main(args: Array[String]): Unit = {
    println(random(100))

    randomMore(6)
  }

  def random(upper : Int) : Int = {
    val random = new Random()
    random.nextInt(upper)
  }

  def randomMore(count : Int) : Unit = {
    val random = new Random(System.currentTimeMillis())
    for(i <- 1 to 10) yield println(random.nextInt(100))
  }
}
```

### 2.8 创建一个数值区间、列表或者数组
在for循环里或者为了测试创建一个数值区间、列表或者数组

- var r = 1 to 10 ------ 得到Range(1, 2, 3,..., 10)
- var r = 1 until 5 ------ 得到Range(1, 2, 3, 4)
- var r = 1 to 10 by 2 -----  得到Range(1, 3, 5, 7, 9)
- for(c <- 1 until 5) println(i)
- val x = (1 to 10).toArray/toList ----- 快速生成列表和数值

### 2.9 格式化数值和金额
对数值或者金额的小数位数或逗号进行格式化，特别是输出时，非常有用

- 基本数值的格式化输出 ----- eg: "f%pi%1.5f"，表示整数位1位，小数位5位
- 简单的加逗号 ----- java.text.NumberFormat.getIntegerInstance

##### 代码:
```
object Number2P8 {

  def main(args: Array[String]): Unit = {
    // 输出: 10,000,000
    System.out.println(printF(10000000))
  }

  def printF(money : Long ) : String = {
    val formatter = java.text.NumberFormat.getIntegerInstance()
    formatter.format(money)
  }
}
```

## 3. 控制结构
Scala语言和Java语言在控制结构部分很像，但是又存在有趣的差别。 [第3章项目源码阅读](https://github.com/thinkingfioa/scala-in-action/tree/master/scala-basic/src/main/scala/org/lwl/scala/basic/chapter/three)

### 3.1 for和foreach循环
循环语句主要用于处理三个问题: 1. 遍历一个集合中的所有元素; 2. 对集合中的每个元素进行某个操作; 3. 利用现有的集合创建新的集合

#### 3.1.1 for循环常用的遍历
个人比较推荐如下for循环语法遍历集合

```
def forF(array : Array[String]): Unit = {
    for(entry <- array) {
      println(entry.toUpperCase())
    }
  }
```

#### 3.1.2 从for循环中返回值
使用for/ield组合，输入一个集合，返回一个新的集合。在for循环添加yield实际上将每次循环的结果放入一个临时存放区。等循环结束后，以集合的形式返回。

```
def forYield(array : Array[String]) : Array[String] = {
	for(entry <- array) yield {
  		entry.toUpperCase()
	}
}
```

#### 3.1.3 for循环计数器
访问循环内的计数器，即通过一个计数器访问数组元素，使用array.indices

```
def forCount(array : Array[String]): Unit = {
  for(i <- array.indices) {
    println(s"$i is ${array(i)}")
  }
}
```

#### 3.1.4 遍历一个Map
遍历Map中的键值对，下面的Map循环方法最简洁和可读

```
def forMap(namesMap : Map[String, Int]) : Unit = {
  for((k,v) <- namesMap) {
    println(s"key is $k, value is $v")
  }
}
```

#### 3.1.5 另一种遍历集合方式
使用foreach, map, flatmap, collect, reduce等方法

1. array.foreach(println) ----- 遍历array数组，可以使用自定义方法替换println方法
2. array.foreach( e => println(e.toUpperCase)) ----- 使用匿名函数的语法
3. array.foreach{ e => | val s = e.toUpperCase | println(s)|} ----- 实现多行函数

#### 3.1.6 for循环式是如何被解释的
提供简化版的规则，帮助理解for循环执行过程

1. 遍历集合的一个简单的for循环被解释为foreach方法调用
2. 带有卫语句的for循环(3.3节)被解释为一个foreach调用后在集合上调用withFilter方法的序列
3. 带有yield表达式的for循环被解释为集合上调用map方法
4. 带有yield表达式和卫语句被解释为在集合上调用withFilter方法，紧接着一个map方法

### 3.2 在for循环中使用多个计数器
创建有多个计数器的循环，如遍历多维数组的情况。推荐使用大括号的代码风格，如下:

##### 代码
```
def forMoreCount() : Unit = {
  for {
    i <- 1 to 3
    j <- 1 to 5
    k <- 1 to 10
  } {
    println("next: ")
    println(s"i : $i, j : $j, k : $k")
  }
}
```

### 3.3 在for循环中嵌入if语句(卫语句)
for循环中添加一个或者多个条件语句，典型的应用场景就是将一个元素从集合中过滤掉。 推荐使用大括号编码风格

#### 代码
```
def forIf() : Unit = {
  for {
    i <- 1 to 10
    if i> 3
    if i<= 8
    if i % 2 == 0
  } println(i)
}
```

### 3.4 创建for表达式( for/yield组合 )
对一个已有的集合中的每个元素应用某个算法，从而生成新的集合。在for循环中使用yield语句的方式通常被叫作for推导

##### 代码
```
def forYieldMoreLine(array : Array[String]) : Array[Int] = {
  for( e <- array) yield {
    val eUpper = e.toUpperCase()
    eUpper.length
  }
}
```

#### 理解for/yield表达式
1. 开始运行时，for/yield循环立刻创建一个新的空集合(Bucket)，类型与输入的集合相同
2. for循环每次遍历，都会在输入集合中的每个元素基础上创建新的元素，加入到Bucket中
3. 循环结束后，Bucket中的所有内容都被返回

### 3.5 实现break和continue
遗憾的是Scala没有break或者continue关键字，但是scala.util.control.Breaks提供了类似的功能。相对于Java来说，Scala的break和continue较为复杂化。个人不喜欢这种风格

##### 代码
```
import util.control.Breaks._

object Ctrl3P5 {

  def forBreak(array : Array[Int]) : Unit = {
    breakable {
      for(i <- array) {
        if(i== 2) {
          break()
        } else {
          print(i+", ")
        }
      }
    }
  }

  def forContinue(array : Array[Int]) : Unit = {
    for(i <- array) {
      breakable {
        if(i== 2) {
          break()
        } else {
          print(i +", ")
        }
      }
    }
  }
}
```

### 3.6 像三元运算符一样使用if
Java提供条件运算符 ? : 称为三元运算符，但是Scala没有提供。在scala中只能使用if/else语句。eg
x >=0 ? "yes": "no" 等价于 if(x>=0) "yes" else "no"

### 3.7 像swtich语句一样使用匹配表达式
Java中基于整数的switch语句，Scala也支持使用@switch注解来满足switch语句，同时@switch注解性能会更优越

##### 代码
```
def switchTypo(i : Int) : String = {
  (i : @switch) match {
    case 1 => "One"
    case 2 => "Two"
    case _ => "Other"
  }
}
```

匹配表达式不局限于整数，它是非常灵活的，如下类型的匹配也是支持的

##### 代码
```
def switchType(x : Any) : String = {
  (x : @switch) match {
    case s : String => "One"
    case i : Int => "Two"
    case _ => "Other"
  }
}
```

#### 3.7.1 处理缺省情况
处理缺省情况的两种情况:

- 不关心缺省匹配的值，使用通配符去捕获 ----- case _ => println("default")
- 关系缺省匹配的值，指定一个变量，然后在表达式右侧使用该变量 ----- case default => println(default)
- 如果不处理缺省情况，可能会产生MatchError错误。所以建议要处理default case

### 3.8 一条case语句匹配多个条件
多个匹配条件需要执行相同的业务逻辑时，使用一条case语句匹配多个条件

##### 代码
```
def moreCase(x : Int) : Unit = {
  (x : @switch) match {
    case 1 | 3 | 5 | 7 | 9 => println("odd")
    case 2 | 4 | 6 | 8 | 10 => println("even")
  }
}
```

### 3.9 将匹配表达式的结果赋值给变量
将一个匹配表达式返回值赋值给一个变量，或将匹配表达式作为方法的主体

```
def isTrue(a : Any) = a match{
  case 0 | "" => false
  case _ => true
}
```

### 3.12 在匹配表达式中使用Case类
在一个匹配表达式中匹配不同的case类（或者case对象）。如下面的代码,Dog和Cat case类以及Woodpecker case对象都是Animal trait的子类型

##### 代码
```
trait Animal

case class Dog(name : String) extends Animal

case class Cat(name : String) extends Animal

case object Woodpecker extends Animal

object Ctrl3P11 {

  def main(args: Array[String]): Unit = {
    println(determineType(Dog("ppp")))
    println(determineType(Cat("fioa")))
    println(determineType(Woodpecker))
  }

  def determineType(x : Animal) : String = x match {
    case Dog(moniker) => "Got a Dog, name = "+moniker
    case _ : Cat => "Got a Cat"
    case Woodpecker => "That was a Wood"
    case _ => "default"
  }

}
```

### 3.13 给Case语句添加if表达式（卫语句)
给匹配的表达式内的case语句添加合适的逻辑，帮助增强case语句的约束条件

```
object Ctrl3P13 {

  def main(args: Array[String]): Unit = {
    caseIfNum(1)
    caseIfNum(2)
  }

  def caseIfNum(x : Int) : Unit = {
    (x : @switch) match {
      case m if m==1 => println("one, a lonely number")
      case n if n==2 || n==3 => println(n)
      case _ => println("default")
    }
  }
}
```

### 3.14 使用匹配表达式替换isInstanceOf
判断对象是否匹配一个类型，可以通过使用isInstanceOf来判断，eg: if(x isInstanceOf[Class]) 。但当需求负责情况写，写一个代码块去匹配一种类型或者多个不同的类型的可读性更好。

##### 代码
```
trait SentientBeing
trait Animal2 extends SentientBeing
case class Pig(name : String) extends Animal2
case class Person(name:String, age : Int) extends SentientBeing

object Ctrl3P14 {

  def main(args: Array[String]): Unit = {
    casePrintInfo(Person("luweilin", 24))
    casePrintInfo(Pig("ppp"))

    if(Pig("ppp").isInstanceOf[SentientBeing]) {
      println("true")
    }
  }


  def casePrintInfo(x : SentientBeing) : Unit = x match {
    case Person(name, age) => println(s"$name is $name, age is $age")
    case Pig(name) => println(s"pig name is $name")
    case _ => println("default")
  }
}
```

### 3.15 在匹配的表达式中使用List
List数据结构和其他的集合数据结构略有不同。列表由单元开始，Nil元素结尾。如果下递归打印内容

```
object Ctrl3P15 {

  def main(args: Array[String]): Unit = {
    val x = List(1,2,3,4)
    println(caseList(x))
  }

  def caseList(x : List[Int]) : String = x match {
    case s :: rest => s +", " + caseList(rest)
    case Nil => ""
  }
}
```

### 3.16 用try/catch匹配一个或多个异常
在try/catch块捕捉一个或者更多的异常

```
def moreException(fileName : String) : Unit = {
  try {
    // read config File
  } catch {
    case e : FileNotFoundException => println("Colud find that file.")
    case e : IOException => println("IOException trying to read that file")
  }
}
```

注意: Scala中没有受检异常，因此不需要指定抛出异常的方法。如果需要声明方法抛出的异常，或者需要和Java交互，在定义方法时添加@throws注解

```
@throws(classOf[NumberFormatException])
def throwException(fileName : String) : Unit = {
  try {
    // read config File
  } catch {
    case e : NumberFormatException => throw e
  }
}
```

### 3.17 在try/catch/finally块中使用变量前定义变量问题
在try代码中使用一个变量，并在finally代码块中访问该对象，如调用对象的close方法。一般情况下，在try/catch块前声明字段为Option，然后在try子句中创建一个Some对象，finally中执行关闭。在Scala中建议不要使用null

##### 代码:
```
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
```

### 3.18 创建自定义控制结构
Scala语言的创造者有意决定通过Scala类库去实现功能而不是去创建一些关键字。典型的例子就是: break和continue关键字。开发者可以自定义控制结构，创建可用的DSL去给他人所用

#### 3.18.1 创建一个类似于while循环控制结构
```
object Ctrl3P18 {

  def main(args: Array[String]): Unit = {
    var i =0
    whilst(i<5) {
      println(s"index: $i")
      i += 1
    }
  }

  @tailrec
  def whilst(testCondition : => Boolean) (codeBlock : => Unit) {
    if(testCondition) {
      codeBlock
      whilst(testCondition)(codeBlock)
    }
  }
}
```

##### 解释:
自定义函数名:whilst，接受两个参数列表，第一个是参数列表测试条件，一个表示用户想要运行的代码块

## 4. 类和属性
与Java相比，Scala在类的声明、构造和字段的访问控制存在很大的差异。Java更啰嗦，Scala更简洁。[第4章项目源码阅读](https://github.com/thinkingfioa/scala-in-action/tree/master/scala-basic/src/main/scala/org/lwl/scala/basic/chapter/four)


### 4.1 创建一个主构造函数
Scala构造函数分为：主构造函数 + 辅助构造函数。一个主构造函数是以下的组合：

1. 构造函数参数
2. 在类内部被调的方法
3. 类内部执行的语句和表达式

```
class Person(var firstName : String, var lastName : String) {
  println("the constructor begins")

  // some class field
  private val HOME = System.getProperty("user.name")
  var age = 0

  override def toString: String = s"$firstName $lastName is $age years old"

  def printHome(): Unit = {
    println(s"HOME = $HOME")
  }

  printHome()
}
```

解释:

1. Scala主构造函数相当模糊，Person类的整个都是主构造函数部分
2. Person类的构造函数中两个参数firstName、lastName被定义为var字段，scala会默认为其添加get/set方法。而属性HOME则没有，private val相当于private final，不可以被其他对象直接访问
3. Scala中描述符: private val，相当于Java中的private final
4. Scala中默认添加的get/set方法，比如上诉代码中age属性，会添加方法名叫age() ----- getter方法，age_$eq(int age) ----- setter方法

### 4.2 控制构造函数字段的可见性(var/val/private)
Scala中构造函数参数可见性，使用var/val/private关键字修饰所控制。可通过下列口诀记住:

1. 如果一个字段被声明为var，Scala会为该字段生成getter和setter方法
2. 如果字段是val，Scala只会生成getter方法
3. 如果一个字段没有var或val修饰符，Scala比较保守，不会生成getter方法和setter方法
4. 字段有使用var或val修饰符，且同时使用private关键字修饰，也不会生成getter方法和setter方法

#### 4.2.1 Case类
case类中构造函数参数的生成方式与其他的类略有不同。Case类的构造函数参数默认是val，生成getter方法，其他类默认不会生成getter方法和setter方法

##### 代码:
```
class OtherPerson(name :String) {

}

case class CasePerson(name : String) {

}

object Class4P2 {
  val otherPerson : OtherPerson = new OtherPerson("fioa")
  val casePerson : CasePerson = CasePerson("ppp")

//  println(s"otherPerson ${otherPerson.name}") 报错
  println(s"casePerson ${casePerson.name}")
}
```

### 4.3 定义辅助构造函数
定义多个辅助构造函数，方便用户通过不同的方式创建对象实例。在类内部以this为名的方法定义辅助构造函数。通过不同的参数列表，定义多个辅助构造函数。提醒：每个构造函数必须调用之前已经定义定义好的构造函数，也就是说，任何辅助构造函数都会调用主构造函数

1. 辅助构造函数必须使用this命名创建
2. 每个辅助构造函数必须调用之前定义的构造函数开始
3. 每个构造函数必须有不同的签名(参数列表)

##### 代码:
```
class Pizza(var crustSize : Int, var crustType : String) {

  def this(crustSize: Int) {
    this(crustSize, Pizza.DEFAULT_CRUST_TYPE)
  }

  override def toString: String = s"Thinking eat Pizza $crustSize, $crustType"
}

object Pizza {
  val DEFAULT_CRUST_SIZE = 12
  val DEFAULT_CRUST_TYPE = "THIN"
}
```

#### 4.3.1 为case类生成辅助构造函数
Case类是一个会自动生成很多模版代码的特殊类。使用类的伴生对象中的apply方法，来为Class类添加一个辅助构造函数

##### 代码
```
case class Person4P2(var name : String, var age : Int)

object Person4P2 {
  def apply(name : String) = new Person4P2(name, 0)
}

object Class4P3 {
  var p : Person4P2 = Person4P2("thinking")
}
```

### 4.4 定义私有的主构造函数 ----- 单例模式需要
为了使用单例，需要建立一个私有主构造函数，使用private关键字。Scala中使用单例，需要用到伴生对象

##### 代码
```
class Brain private (var name : String, var speed : Long) {

  override def toString: String = s"$name have $speed ms"

  def printBrain() : Unit = {
    print(toString())
  }
}

object Brain {
  val brain = new Brain("thinking", 1)
  def getIntance: Brain = brain
}

object Class4P4 {
  def main(args: Array[String]): Unit = {
    Brain.getIntance.printBrain()
  }
}
```

##### 伴生对象 ----- 讨论
简单来说，一个伴生对象就是定义在与类的同一个文件中，同时对象和类有相同的名字。如上object Brain是类Brain的伴生对象。伴生对象类中的方法都是该对象的静态方法，类似于Java中的静态类

### 4.5 设置构造函数参数的默认值
给构造函数参数提供一个默认值，在调用构造函数时可以指定或者也可以不指定参数。 eg： class Socket(val timeout : Int = 1000)

##### 代码
```
class Socket (val timeout : Int = 1000) {

}

object Class4P5 {

  def main(args: Array[String]): Unit = {
    val socket : Socket = new Socket(timeout = 3000)
  }
}
```

### 4.6 覆写默认的访问和修改方法
覆写Scala自动生成的getter或者setter。Scala中这个优点麻烦，推荐下列方法来实现

```
class Stock(var _symbol : String) {
  def symbol() : String = _symbol

  def symbol_ (s :String) : Unit =  {
    this._symbol = symbol
  }
}
```

### 4.7 阻止生成getter和setter方法
Scala中如果某个变量定义为var，将会自动生成getter和setter方法;如果变量定义成val，将会自动生成setter方法

1. 如果是class，字段没有使用var/val修饰，则不会生成getter和setter方法。如果是case class，字段没有使用var/val修饰，默认为val，生成getter方法
2. 使用private或private[this]访问修饰符定义字段

#### private 和 private[this]对比
1. 使用private修饰字段，则Scala不会自动生成getter和setter方法。
2. 定义一个private[this]字段让私有化更进一步，让字段对象私有化
3. 如下代码，price字段无法被相同类型的其他实例访问

##### 代码
```
class Book {
  private[this] var price : Double = _

  def setPrice(price:Double ): Unit = {
    this.price = price
  }

  def isHigher(that : Book): Boolean = {
    // 报错，无法在this对象中访问that对象的price
//    this.price > that.price
    true
  }
}
```

### 4.8 将代码块或者函数赋给字段


















