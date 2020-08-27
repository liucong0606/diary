# Pinyin4J

## 概述

​	`Pinyin4j` 是一个流行的Java库，常用于将汉字（简体或繁体）转化成拼音，还可以选择声调的有无和格式。



## 拼音格式化

```java
 HanyuPinyinOutputFormat f = new HanyuPinyinOutputFormat();
```



**常用方法**

| 方法名         | 解释                     | 参数                                                         |
| -------------- | ------------------------ | ------------------------------------------------------------ |
| setCaseType()  | 设置拼音 **大小写** 格式 | `HanyuPinyinCaseType.UPPERCASE`  转 **大写**<br />`HanyuPinyinCaseType.LOWERCASE`  转 **小写** |
| setToneType()  | 设置拼音 **声调** 位置   | `HanyuPinyinToneType.WITHOUT_TONE`   **不标** 声调<br />`HanyuPinyinToneType.WITH_TONE_MARK`  声调 **上置** 如á<br />`HanyuPinyinToneType.WITH_TONE_NUMBER`   声调 **右置** |
| setVCharType() | 设置韵母 **ü** 的格式    | `HanyuPinyinVCharType.WITH_U_AND_COLON` **u:**表示<br />`HanyuPinyinVCharType.WITH_V`   **v** 表示<br />`HanyuPinyinVCharType.WITH_U_UNICODE`  **ü** 表示 |



## 转化全拼音

使用 `PinyinHelper` 工具类的静态方法进行拼音转化；

`toHanyuPinyinStringArray` 参数是 **一个字符**， 返回 **一个字符串数组**，数组为了方便存储多音字；

默认声调靠右，数字形式显示；

默认 **ü** 显示 成 `u:`。

```java
String[] s = PinyinHelper.toHanyuPinyinStringArray('女');
System.out.println(Arrays.toString(s));
```

```
[nu:3, ru3]
```



使用拼音格式化转化成可读性更好的拼音：

```java
HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);  // 显示 ü
format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);		// 声调置顶 ǚ
String[] s = PinyinHelper.toHanyuPinyinStringArray('女', format);  // 加上格式化对象参数
System.out.println(Arrays.toString(s));
```

```
[nǚ, rŭ]
```



## 常见问题

* 如果需要声调置顶，那 `ü` 的显示一定要是 `ü`，否则报异常 `BadHanyuPinyinOutputFormatCombination: tone marks cannot be added to v or u` 。
* 如果汉字是多音字，那拼音有可能无法达到预期效果。



























