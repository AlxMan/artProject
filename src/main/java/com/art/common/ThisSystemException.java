package com.art.common;

/**
 * @Description TODO
 * @Author art
 * @Date 2018/7/19 16:26
 * @Version 1.0
 */
    public class ThisSystemException extends RuntimeException{
    public ThisSystemException(String message) {
        super(message);
    }

    public ThisSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}