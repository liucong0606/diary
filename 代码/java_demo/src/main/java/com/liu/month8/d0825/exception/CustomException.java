package com.liu.month8.d0825.exception;

/**
 * @author liucong
 * @ClassName: CustomException
 * @Description:
 * @date: 2020/8/25 13:45
 */
public class CustomException extends Exception {
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }
}
