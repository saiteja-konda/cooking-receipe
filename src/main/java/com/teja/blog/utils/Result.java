package com.teja.blog.utils;

import Constants.CommonConstants;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class Result implements Serializable {

    private int code = CommonConstants.SUCCESS;
    private Object message = "success";
    private Object data;

    public Result() {
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(int code, Object message) {
        this.code = code;
        this.message = message;
    }

    public Result(Object message, Object data) {
        this.message = message;
        this.data = data;
    }

    public Result(HttpStatus statusCode) {
        this.code = statusCode.value();
        this.message = statusCode.getReasonPhrase();
    }

    public Result(Throwable e) {
        this.code = CommonConstants.ERROR;
        this.message = e.getMessage();
    }

    public Result(String message, Throwable e) {
        this.message = message;
        this.code = CommonConstants.ERROR;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
