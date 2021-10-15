package com.ljp.test.json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class JsonTest {

	/**
	 * gson
	 * {"one":[{"id":1,"name":"one"},{"id":2,"name":"two"}],"two":[{"id":1,"name":"one"},{"id":2,"name":"two"}]}
	 * jackson
	 * {"one":[{"id":1,"name":"one"},{"id":2,"name":"two"}],"two":[{"id":1,"name":"one"},{"id":2,"name":"two"}]}
	 * fastjson
	 * {"one":[{"id":1,"name":"one"},{"id":2,"name":"two"}],"two":[{"$ref":"$.one[0]"},{"$ref":"$.one[1]"}]}
	 * {"one":[{"id":1,"name":"one"},{"id":2,"name":"two"}],"two":[{"id":1,"name":"one"},{"id":2,"name":"two"}]}
	 * <p>
	 * 结论：fastjson序列化list对象中包含相同元素，会出现序列化问题
	 *
	 * @throws JsonProcessingException 序列化异常
	 */
	@Test
	public void testOne() throws JsonProcessingException {
		LinkedHashMap<String, Object> oneLinkedHashMap = Maps.newLinkedHashMap();
		oneLinkedHashMap.put("id", 1);
		oneLinkedHashMap.put("name", "one");
		LinkedHashMap<String, Object> twoLinkedHashMap = Maps.newLinkedHashMap();
		twoLinkedHashMap.put("id", 2);
		twoLinkedHashMap.put("name", "two");
		ArrayList<LinkedHashMap<String, Object>> oneList = Lists.newArrayList(oneLinkedHashMap, twoLinkedHashMap);
		ArrayList<LinkedHashMap<String, Object>> twoList = Lists.newArrayList(oneLinkedHashMap, twoLinkedHashMap);
		LinkedHashMap<String, Object> linkedHashMap = Maps.newLinkedHashMap();
		linkedHashMap.put("one", oneList);
		linkedHashMap.put("two", twoList);
		System.out.println("gson");
//		Gson gson = new GsonBuilder().create();
//		Type type = new TypeToken<LinkedHashMap<String, Object>>() {
//		}.getType();
//		System.out.println(gson.toJson(linkedHashMap, type));
		System.out.println("jackson");
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(linkedHashMap));
		System.out.println("fastjson");
		System.out.println(JSONObject.toJSONString(linkedHashMap));
		System.out.println(JSONObject.toJSONString(linkedHashMap, SerializerFeature.DisableCircularReferenceDetect));
	}

}
