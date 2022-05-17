package com.ctg.cartier.pojo.until;

public class Result<T> {
    private int retCode;
    private String msg;
    private T data;

    public Result(int retCode, String msg, T data) {
        this.retCode = retCode;
        this.msg = msg;
        this.data = data;
    }

    public Result() {

    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
