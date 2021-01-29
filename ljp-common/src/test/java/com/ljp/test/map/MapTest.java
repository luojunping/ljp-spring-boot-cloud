package com.ljp.test.map;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		HashMap<String, String> firstMap = Maps.newHashMap();
		firstMap.put("a", "a");
		firstMap.put("b", "b");
		firstMap.put("c", "wd");
		HashMap<String, String> secondMap = Maps.newHashMap();
		secondMap.put("d", "d");
		secondMap.put("b", "b");
		secondMap.put("c", "dw");
		MapDifference<String, String> mapDifference = Maps.difference(firstMap, secondMap);
		Map<String, String> inCommonMap = mapDifference.entriesInCommon();
		Map<String, String> leftMap = mapDifference.entriesOnlyOnLeft();
		Map<String, String> rightMap = mapDifference.entriesOnlyOnRight();
		Map<String, MapDifference.ValueDifference<String>> differingMap = mapDifference.entriesDiffering();
		System.out.println("inCommonMap = " + inCommonMap);
		System.out.println("leftMap = " + leftMap);
		System.out.println("rightMap = " + rightMap);
		System.out.println("differingMap = " + differingMap);
	}

	@Test
	public void testOne() {
		HashMultimap<String, String> hashMultimap = HashMultimap.create();
		hashMultimap.put("fruits", "apple");
		hashMultimap.put("fruits", "banana");
		hashMultimap.put("fruits", "orange");
		hashMultimap.put("name", "张三");
		hashMultimap.forEach((k, v) -> {
			System.out.println(k + "::" + v);
		});
		System.out.println("hashMultimap.size() = " + hashMultimap.size());
		hashMultimap.asMap().forEach((k, v) -> {
			System.out.println(k + "::" + v);
		});
	}

	@Test
	public void testTwo() {
		final String wd = "林学类(成栋实验班)";
		System.out.println(wd.replaceAll("\\(.*\\)", ""));
	}

}
