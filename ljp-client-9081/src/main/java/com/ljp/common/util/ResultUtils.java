package com.ljp.common.util;

import com.ljp.common.vo.Result;

public class ResultUtils {

	private ResultUtils() {

	}

	/**
	 * 默认成功请求返回
	 * 
	 * @return
	 */
	public static Result success() {
		return success(null);
	}

	/**
	 * 返回带有错误码和错误描述信息的和详情
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static Result success(String msg) {
		Result result = new Result();
		result.setSuccess(true);
		result.setMsg(msg);
		return result;
	}

	/**
	 * 带有返回数据的 返回
	 * 
	 * @param body
	 * @return
	 */
	public static Result success(Object data) {
		Result result = new Result();
		result.setSuccess(true);
		result.setData(data);
		return result;
	}

	/**
	 * 返回带有错误码和错误描述信息的和详情
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static Result success(String msg, Object data) {
		Result result = new Result();
		result.setSuccess(true);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}

	/**
	 * 默认的错误返回
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static Result failed() {
		return failed(null, null);
	}

	/**
	 * 返回带有错误码和错误描述信息的
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static Result failed(String msg) {
		return failed(msg, null);
	}

	/**
	 * 返回带有错误码和错误描述信息的和详情
	 * 
	 * @param code
	 * @param msg
	 * @return
	 */
	public static Result failed(String msg, Object data) {
		Result result = new Result();
		result.setSuccess(false);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}

}
