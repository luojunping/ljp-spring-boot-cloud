package com.ljp.test.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;

import java.util.List;

public class RedisTest {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		ScanParams scanParams = new ScanParams();
		scanParams.count(100).match("configCache*");
		ScanResult<String> scanResult = jedis.scan("0", scanParams);
		List<String> keyList = scanResult.getResult();
		for (String key : keyList) {
			System.out.println(key);
		}
	}

}
