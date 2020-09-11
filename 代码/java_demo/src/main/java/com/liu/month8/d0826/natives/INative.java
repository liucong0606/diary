package com.liu.month8.d0826.natives;

/**
 * @author liucong
 * @ClassName: INative
 * @Description:
 * @date: 2020/8/26 11:35
 */
public class INative {
    native public void sing(String singer);

    static {
        // System.load("C:\\Java\\java_demo\\src\\main\\java\\com\\liu\\d0826\\natives\\INativeImpl.dylib");
    }

    public static void main(String[] args) {
        INative in = new INative();
        in.sing("周杰伦");
    }
}
