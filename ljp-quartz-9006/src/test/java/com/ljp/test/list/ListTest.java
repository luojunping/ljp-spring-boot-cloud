package com.ljp.test.list;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {

	@Test
	public void testOne() {
		List<String> stringList = Arrays.asList("a", "b", "c");
		String result = stringList.stream().collect(Collectors.joining("-"));
		System.out.println("result = " + result);
		result = String.join(":", stringList);
		System.out.println("result = " + result);
		System.out.println(Objects.equals("a", "b"));
		System.out.println(Objects.equals(null, null));
		System.out.println(null == null);
	}

	@Test
	public void testTwo() {
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add("b");
		list2.add("d");
		list1.retainAll(list2);
		System.out.println(list1); // 输出[a, b]  
		System.out.println(list2); // 输出[a, b]
	}

	@Test
	public void testThree() {
		Map<String, String> m1 = new HashMap<>();
		Map<String, String> m2 = new LinkedHashMap<>();
		System.out.println(m1 instanceof AbstractMap);
		System.out.println(m2 instanceof HashMap);
		System.out.println(m1 instanceof LinkedHashMap);
		System.out.println(m2 instanceof LinkedHashMap);
	}

}
