package com.liu.month8.d0825.utils;

import com.liu.month8.d0825.exception.CustomException;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author liucong
 * @ClassName: BaseUtil
 * @Description:
 * @date: 2020/8/25 9:21
 */
public class BaseUtil {
    private static final String SET_WORD = "set";
    private static final String GET_WORD = "get";

    private BaseUtil() {
    }


    /**
     * @Description: 将 Map集合 映射成 对象
     * @auther: liucong
     * @date: 2020/8/25 10:43
     * @return:
     */
    public static <T> T populate(Map m, Class<T> c) {
        T obj = null;
        try {
            obj = c.newInstance();
            Method[] methods = c.getMethods();
            for (Method method : methods) {
                String name = method.getName();
                if (m.containsKey(cancelSet(name))) {
                    method.invoke(obj, m.get(cancelSet(name)));
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * @Description: 对象 转 Map集合
     * @auther: liucong
     * @date: 2020/8/25 11:00
     * @return:
     */
    public static Map Object2Map(Object obj) {
        Map map = new HashMap();
        Class<?> aClass = obj.getClass();
        Field[] fields = aClass.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String name = field.getName();
                Method method = aClass.getMethod(GET_WORD + capitalize(name));
                Object value = method.invoke(obj);
                map.put(name, value);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * @Description: 判断对象是否为空
     * @auther: liucong
     * @date: 2020/8/25 10:27
     * @return:
     */
    public static boolean isEmpty(Object obj) {
        return null == obj;
    }

    /**
     * @Description: 首字母大写
     * @auther: liucong
     * @date: 2020/8/25 10:22
     * @return:
     */
    public static String capitalize(String str) {
        String value = null;
        if (!isEmpty(str) && str.length() > 0) {
            String firstWord = String.valueOf(str.charAt(0)).toUpperCase();
            String substring = str.substring(1);
            value = firstWord + substring;
        }
        return value;
    }

    /**
     * @Description: 首字母小写
     * @auther: liucong
     * @date: 2020/8/25 10:22
     * @return:
     */
    public static String uncapitalize(String str) {
        String value = null;
        if (!isEmpty(str) && str.length() > 0) {
            String firstWord = String.valueOf(str.charAt(0)).toLowerCase();
            String substring = str.substring(1);
            value = firstWord + substring;
        }
        return value;
    }

    /**
     * @Description: 去掉get，首字母小写
     * @auther: liucong
     * @date: 2020/8/25 10:21
     * @return:
     */
    public static String cancelGet(String str) {
        String value = null;
        if (!isEmpty(str) && str.startsWith(GET_WORD)) {
            value = uncapitalize(str.substring(3));
        }
        return value;
    }

    /**
     * @Description: 去掉set，首字母小写
     * @auther: liucong
     * @date: 2020/8/25 10:22
     * @return:
     */
    public static String cancelSet(String str) {
        String value = null;
        if (!isEmpty(str) && str.startsWith(SET_WORD)) {
            value = uncapitalize(str.substring(3));
        }
        return value;
    }

    /**
     * @Description: 获取拼音
     * @auther: liucong
     * @date: 2020/8/25 11:41
     * @return:
     */
    public static String getSpellWord(String key) {
        HanyuPinyinOutputFormat f = new HanyuPinyinOutputFormat();
        f.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        String value = null;
        if (!isEmpty(key) && key.length() > 0) {
            value = "";
            for (int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                String[] s = new String[0];
                try {
                    s = PinyinHelper.toHanyuPinyinStringArray(ch, f);
                } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                    badHanyuPinyinOutputFormatCombination.printStackTrace();
                }
                for (String s1 : s) {
                    value = value + s1;
                }
            }
        }
        return value;
    }

    /**
     * @Description: 获取字符的首字母，并大写
     * @auther: liucong
     * @date: 2020/8/25 13:40
     * @return:
     */
    public static char getFirstWord(char c) {
        return PinyinHelper.toHanyuPinyinStringArray(c)[0].toUpperCase().charAt(0);
    }

    /**
     * @Description: 获取单词的首字母大写
     * @auther: liucong
     * @date: 2020/8/25 13:44
     * @return:
     */
    public static char getFirstWord(String str) {
        if (!isEmpty(str) && str.length() > 0)
            return getFirstWord(str.charAt(0));
        else
            try {
                throw new CustomException("str为null，或者str是空字符串");
            } catch (CustomException e) {
                e.printStackTrace();
            }
        return ' ';
    }

    /**
     * @Description: 根据多个单词，获取多个单词的首字母
     * @auther: liucong
     * @date: 2020/8/25 14:01
     * @return:
     */
    public static char[] getFirstWord4ManyWord(String str) {
        if (isEmpty(str) || str.length() == 0) {
            try {
                throw new CustomException("str为null，或者str是空字符串");
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            char firstWord = getFirstWord(c);
            list.add(firstWord);
        }
        char[] chs = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            chs[i] = list.get(i);
        }
        return chs;
    }
}
