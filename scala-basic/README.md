# scala-basic 基础篇

```
@author 鲁伟林
Scala基础知识介绍，主要包括《Scala编程实战》的第1章、


GitHub地址: https://github.com/thinkingfioa/netty-learning/tree/master/netty-private-protocol
本人博客地址: http://blog.csdn.net/thinking_fioa/article/details/78265745
```

## 第一章 字符串

### 1. 引言
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

使用方式:

1. 将方法或变量标记为implicit
2. 将方法的参数列表标记为implicit
3. 将类标记为implicit

 































