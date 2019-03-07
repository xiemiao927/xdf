package com.cn.utils;


import java.util.HashMap;

/**
 *返回数据
 */
public class ResultBean extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;
    private static final String RESULT = "result";
    private static final String MESSAGE = "message";
    private static final String DATA = "data";

    public ResultBean() {
        put(RESULT, Constant.Result.SUCCESS.getValue());
        put(MESSAGE, Constant.Message.SUCCESS.getValue());
    }

    public static ResultBean error() {
        return error(Constant.Result.FAIL.getValue(), Constant.Message.UNKNOWN.getValue());
    }

    public static ResultBean error(String msg) {
        return error(Constant.Result.FAIL.getValue(), msg);
    }

    public static ResultBean error(int code, String msg) {
        ResultBean ResultBean = new ResultBean();
        ResultBean.put(RESULT, code);
        ResultBean.put(MESSAGE, msg);
        return ResultBean;
    }

    public static ResultBean error(int code, String msg, Object obj) {
        ResultBean ResultBean = new ResultBean();
        ResultBean.put(RESULT, code);
        ResultBean.put(MESSAGE, msg);
        ResultBean.put(DATA, obj);
        return ResultBean;
    }

    public static ResultBean ok(String msg) {
        ResultBean ResultBean = new ResultBean();
        ResultBean.put(MESSAGE, msg);
        return ResultBean;
    }

    public static ResultBean ok(Object obj) {
        ResultBean ResultBean = new ResultBean();
        ResultBean.put("data", obj);
        return ResultBean;
    }

    public static ResultBean ok() {
        return new ResultBean();
    }

    @Override
    public ResultBean put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}

