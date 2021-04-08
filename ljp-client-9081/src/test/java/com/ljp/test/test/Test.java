package com.ljp.test.test;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		HashMap<String, String> entityHashMap = Maps.newHashMap();
		entityHashMap.put("schoolId", "1500000200047408920");
		entityHashMap.put("provinceName", "重庆");
		JSONObject jsonObject = SignUtils.syncSchoolProvince(JSONObject.toJSONString(entityHashMap));
		System.out.println("jsonObject = " + jsonObject);
	}

}
