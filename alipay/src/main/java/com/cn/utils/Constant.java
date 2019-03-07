package com.cn.utils;

/**
 * 常量
 */
public class Constant {
    /**
     * 超级管理员ID
     */
    public static final int SUPER_ADMIN = 1;



    /**
     * 响应结果
     */
    public enum Result {
        //请求成功
        SUCCESS(200),
        //请求失败
        FAIL(500);


        private int value;

        Result(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 响应消息
     */
    public enum Message {
        //请求成功
        SUCCESS("成功"),
        //请求失败
        FAIL("失败"),
        //未知错误
        UNKNOWN("系统异常");


        private String value;

        Message(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }



}
