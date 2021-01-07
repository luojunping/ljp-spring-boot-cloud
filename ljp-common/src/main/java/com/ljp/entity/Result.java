package com.ljp.entity;

/**
 * <b>统一的返回结果</b>
 *
 * @author 罗俊平
 * @create in 2020年11月7日
 * @update in 2020年11月7日
 * @since 1.0.0
 */
public class Result {

    /* 返回状态 */
    private int code;
    /* 返回信息描述 */
    private String msg;
    /* 返回的body */
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
