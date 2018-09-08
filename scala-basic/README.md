# scala-basic 基础篇

```
@author 鲁伟林
Scala基础知识介绍，主要包括《Scala编程实战》的第1章、

GitHub地址: https://github.com/thinkingfioa/scala-in-action
本人博客地址: http://blog.csdn.net/thinking_fioa/article/details/78265745
```

# 第一章 字符串
[项目地址ChapterOne](https://github.com/thinkingfioa/scala-in-action/tree/master/scala-basic/src/main/scala/org/lwl/scala/basic/chapter/one)

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
2. 使用特殊字符+stripMargin，达到多行字符串都是定格写
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


 































