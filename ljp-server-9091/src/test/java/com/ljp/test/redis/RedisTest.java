package com.ljp.test.redis;

import org.junit.jupiter.api.Test;
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

	@Test
	public void testOne() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		Long lpushNum = jedis.lpush("redis:message:queue", "0", "1", "2");
		System.out.println("lpushNum = " + lpushNum);
		String rpopObj = jedis.rpop("redis:message:queue");
		System.out.println("rpopObj = " + rpopObj);
		List<String> redisMessageQueue = jedis.lrange("redis:message:queue", 0, -1);
		System.out.println("redisMessageQueue = " + redisMessageQueue);
	}

}
