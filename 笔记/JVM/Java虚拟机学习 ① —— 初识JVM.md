# Java虚拟机学习 ① —— 初识JVM

## 学习摘自

**（博客性质属于学习笔记，如发现雷同，不用质疑，这就是抄的）**

* 《深入理解Java虚拟机  JVM高级特性与最佳实践》  周志明 著
* https://blog.csdn.net/TZ845195485/article/details/108096523

**（如有冒犯以上博客链接，请联系我删除）**



## 什么是JVM

`JVM` ，又称 **Java虚拟机** 。谈起 `JVM` ，那就会想到 Java 喊得口号 **“Wite Once，Run Anywhere”**，那 `JVM` 和 `跨平台性` 有什么联系呢？

JVM 是一个虚构出来的计算机，通过在实际的计算机上仿真模拟出各种计算机功能来实现的。它可以将 `.class` 字节码文件 **编译成机器语言** ，以便计算机识别。Java程序就是在JVM中运行的。

一般的高级语言如果要在不同的平台上运行，至少需要 **编译** 成不同的目标代码。而引入 **Java语言虚拟机** 后，Java语言在 **不同平台** 上运行时 **不需要重新编译** ，只需在机器上安装对应系统版本的虚拟机即可，Java虚拟机在执行字节码时，把字节码解释成具体平台上的机器指令执行。



## 学习 JVM 目的

1. 让我们更加了解Java这门语言；
2. 面试时具备和面试官吹牛🈲的资本；
3. 在行业里提升竞争力。



## 各大Java虚拟机

### Sun Classic

Sun Classic VM 技术很原始，因时代变迁已经淘汰了，但是它是 **世界上第一款商用Java虚拟机**。

这款虚拟机只能使用 **纯解释器方式** 来执行Java代码，它在 **JDK 1.2**  之前是Sun JDK中唯一的虚拟机，JDK 1.2时时，它与 HotSpot VM 并存，但默认使用的虚拟机仍然时 Sun Classic VM，而在 **JDK 1.3** 时，HotSpot VM 成为了默认虚拟机，**JDK 1.4** 之后 Sun Classic VM 永远的退出了虚拟机历史。



### Sun HotSpot VM

HotSpot VM 是 **Sun JDK** 和 **Open JDK** 中自带的虚拟机，它是世界上 **使用范围最广** 的Java虚拟机。它并非是Sun公司研发的，"Longview Technologies" 公司设计了 Strongtalk VM，于1997年，Sun公司收购了 Longview Technologies 公司，从而获得 **HotSpot VM**。

在 2008 年和 2009 年，**Oracle** 公司 收购了 BEA 公司 和 Sun 公司，Oracle 得到了两款优秀的Java虚拟机：**JRockit VM** 和 **HotSpot VM**，Oracle公司宣布会将这两个优秀虚拟机完成了 **整合** ，使之优势互补。



### JRockit VM

JRockit VM 曾经号称 **世界上速度最快的Java虚拟机（广告词）** ，**BEA** 公司将其发展为一款专门为服务器硬件和服务器端应用场景高度优化的虚拟机，由于专注于 **服务器端应用** ，它不太关注程序启动速度。



### IBM J9 VM

IBM J9 VM 是 **IBM** 公司主力发展的Java虚拟机，IBM J9 的市场定位和 HotSpot 比较接近，它是一款设计上从 **服务器端** 到 **桌面应用** 再到 **嵌入式** 都全面考虑的多用途虚拟机。J9 的开发目的是作为 IBM公司各种 **Java产品** 的执行平台，它的主要市场是和 **IBM产品 **搭配以及在 IBM AJX 和 z/OS 这些平台上部署Java应用。

