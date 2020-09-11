package com.liu.month8.d0814.singleton;

/**
 * ClassName: EnumSingleton <br/>
 * Description: <br/>
 * date: 2020/8/14 8:49<br/>
 *
 * @author zhuan<br />
 * @since JDK 1.8
 */
public enum EnumSingleton {
    // 枚举实现单例
    SINGLETON;

    private EnumSingleton() {}

    public static EnumSingleton getInstance() {
        return SINGLETON;
    }
}
