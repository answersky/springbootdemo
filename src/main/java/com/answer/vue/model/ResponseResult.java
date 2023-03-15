package com.answer.vue.model;

import lombok.Data;

@Data
public class ResponseResult<T> {
    private String code;
    private String msg;
    private T data;

    private static final String SUCCESS = "200";
    private static final String FAIL = "400";

    public ResponseResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseResult success() {
        return new ResponseResult(SUCCESS, null, null);
    }

    public static ResponseResult success(Object data) {
        return new ResponseResult(SUCCESS, null, data);
    }

    public static ResponseResult fail() {
        return new ResponseResult(FAIL, null, null);
    }

    public static ResponseResult fail(String msg) {
        return new ResponseResult(FAIL, msg, null);
    }
}
