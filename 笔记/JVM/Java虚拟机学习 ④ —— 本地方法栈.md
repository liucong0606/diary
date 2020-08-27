# Java虚拟机学习 ④ —— 本地方法栈

## 学习摘自

**（博客性质属于学习笔记，如发现雷同，不用质疑，这就是抄的）**

* 《深入理解Java虚拟机  JVM高级特性与最佳实践》  周志明 著
* https://www.cnblogs.com/wade-luffy/p/5813747.html
* https://blog.csdn.net/qq_33605778/article/details/78719879

**（如有冒犯以上博客链接，请联系我删除）**



## 概述

* 本地方法栈是一个后入先出的栈。

* 本地方法栈所发挥的作用与虚拟机栈所发挥的作用时非常相似的，它们之间的区别不过是虚拟机栈为虚拟机执行Java方法（也就是字节码）服务，而本地方法栈则为虚拟机使用到的本地方法服务。
* 当线程调用Java方法时，虚拟机会创建一个新的栈帧并压入Java栈。然而当它调用的是本地方法时，虚拟机会保持虚拟机栈不变，不再在线程的虚拟机栈中压入新的帧，虚拟机只是简单的动态链接并直接调用指定的本地方法。
* Navtive 方法是Java通过JNI直接调用本地C库，可以认为是Native方法相当于C暴露给Java的一个接口，Java通过这个接口从而调用到C方法。
* 由于本地方法栈是线程私有的，生命周期随着线程，线程启动而产生，线程结束而消亡。
* 本地方法栈会抛出 StackOverflowError 和 OutOfMemoryError 异常。



## native方法

```java
public class INative {
    native public void method1();
}
```

以上native方法看起来与abstract方法差不多，native方法相当于是给C库做抽象方法，而abstract方法是给Java代码做抽象方法。
