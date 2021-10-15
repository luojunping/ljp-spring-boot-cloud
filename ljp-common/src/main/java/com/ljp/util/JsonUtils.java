package com.ljp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.ljp.security.UserDTO;
import com.ljp.security.UserVO;

/**
 * json工具类
 */
public final class JsonUtils {

	private static final JsonMapper JM = new JsonMapper();

	static {

	}

	private JsonUtils() throws IllegalAccessException {
		throw new IllegalAccessException("JsonUtils can not be created !!!");
	}

	public static <T> T parseObject(String content, Class<T> clazz) {
		T t = null;
		try {
			t = JM.readValue(content, clazz);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return t;
	}

	public static String toJSONString(Object object) {
		String content = null;
		try {
			content = JM.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return content;
	}

	public static void main(String[] args) {
		UserDTO userDTO = new UserDTO();
		userDTO.setLoginName("zhangsan");
		String ss = JsonUtils.toJSONString(userDTO);
		System.out.println("ss = " + ss);
		UserVO userVO = JsonUtils.parseObject(ss, UserVO.class);
		System.out.println("userVO = " + userVO);

	}

}
