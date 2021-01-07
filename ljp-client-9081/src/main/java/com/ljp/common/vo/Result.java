package com.ljp.common.vo;

public class Result {

	/* 返回状态 */
	private boolean success;
	/* 返回信息描述 */
	private String msg;
	/* 返回的body */
	private Object data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
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
