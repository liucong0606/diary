# Pinyin4J

## 拼音格式化

**常用方法**

| 方法名         | 解释                     | 参数                                                         |
| -------------- | ------------------------ | ------------------------------------------------------------ |
| setCaseType()  | 设置拼音 **大小写** 格式 | `HanyuPinyinCaseType.UPPERCASE`  转 **大写**<br />`HanyuPinyinCaseType.LOWERCASE`  转 **小写** |
| setToneType()  | 设置拼音 **声调** 位置   | `HanyuPinyinToneType.WITHOUT_TONE`   **不标** 声调<br />`HanyuPinyinToneType.WITH_TONE_MARK`  声调 **上置** 如á<br />`HanyuPinyinToneType.WITH_TONE_NUMBER`   声调 **右置** |
| setVCharType() | 设置韵母 **ü** 的格式    | `HanyuPinyinVCharType.WITH_U_AND_COLON` **u:**表示<br />`HanyuPinyinVCharType.WITH_V`   **v** 表示<br />`HanyuPinyinVCharType.WITH_U_UNICODE`  **ü** 表示 |



```java
HanyuPinyinOutputFormat f = new HanyuPinyinOutputFormat();
```





































