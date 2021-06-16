package com.ljp.test.log;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.*;

@Slf4j
public class LogbackTest {

	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		Integer c = null;
		Boolean flag = false;// a*b的结果是int类型，那么c会强制拆箱成int类型，抛出NPE异常
		Integer result = (flag ? a * b : c);
		// log.error("hello world : {}", LogbackTest.class.getName());
		try {
			Thread thread = new Thread(() -> {
				System.out.println(1 / 0);
			});
			thread.start();
		} catch (Exception e) {
			System.out.println("hello world : " + e.getLocalizedMessage());
			log.error("hello world : {}", e.getLocalizedMessage());
		}
		method(null);
	}

	public static void method(String param) {
		switch (param) { // 肯定不是进入这里
			case "sth":
				System.out.println("it's sth");
				break; // 也不是进入这里
			case "null":
				System.out.println("it's null");
				break; // 也不是进入这里
			default:
				System.out.println("default");
		}
	}

	@Test
	public void testOne() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		ArrayList<Float> arrayList = Lists.newArrayList(1.9F, 2.5F, 3.5F, 4.5F);
		double result = arrayList.stream().mapToDouble(score -> score.doubleValue()).average().getAsDouble();
		System.out.println("result = " + result);
		System.out.println("result = " + decimalFormat.format(result));
	}

	@Test
	public void testTwo() {
		log.error("当前省份（{}）为非新高考省份，没有相关的覆盖率数据！", "安徽");
		System.out.println(0x00ff);
		System.out.println(255 / 15);
	}

	@Test
	public void testThree() {
		SecureRandom secureRandom = new SecureRandom();
		String[] batchArray = {"本科一批", "本科二批"};
		String[] schoolYearArray = {"2012", "2013", "2014", "2015", "2016", "2017"};
		Map<String, Map<String, Integer>> mapp = new HashMap<>();
		for (int j = 0; j < 12; j++) {
			Integer avgScore = 600;
			Integer provinceControlLine = 500;
			String schoolYear = schoolYearArray[j / 2];
			String batch = batchArray[secureRandom.nextInt(2)];
			Map<String, Integer> tempMap = mapp.computeIfAbsent(batch, k -> new LinkedHashMap<>());
			tempMap.put(schoolYear, avgScore - provinceControlLine);
		}
		System.out.println("mapp = " + mapp);
		if (mapp.size() == 2) {
			Map<String, Integer> oneMap = mapp.get("本科一批");
			Map<String, Integer> twoMap = mapp.get("本科二批");
			Iterator<String> oneIterator = oneMap.keySet().iterator();
			while (oneIterator.hasNext()) {
				if (!twoMap.containsKey(oneIterator.next())) {
					oneIterator.remove();
				}
			}
			Iterator<String> twoIterator = twoMap.keySet().iterator();
			while (twoIterator.hasNext()) {
				if (!oneMap.containsKey(twoIterator.next())) {
					twoIterator.remove();
				}
			}
		}
		System.out.println("mapp = " + mapp);
	}

	@Test
	public void testFour() {
		int num = 1;
		System.out.println(++num == 1);
		System.out.println(num);
		num = 1;
		System.out.println((++num) == 1);
		System.out.println(num);
		char ss = 'A';
		System.out.println((int) ss);
		Byte a = 127;
		Byte b = 127;
		System.out.println(a == b);
		int i = 100;
		// \u000a System.out.println("Hello World!");
		i = +2; //注意，加号在后面
		System.out.println(i);
	}

}
