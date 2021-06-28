package com.ljp.test.redis;

import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.*;
import redis.clients.jedis.util.JedisClusterCRC16;

import java.util.*;

public class JedisTest {

	@Test
	public void testOne() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 10 * 1000);
		Jedis jedis = jedisPool.getResource();
		Long resultNum = jedis.msetnx("beijing", "china", "shanghai", "china", "guangzhou", "china");
		System.out.println("resultNum = " + resultNum);
		List<String> resultList = jedis.mget("beijing", "shanghai", "guangzhou");
		resultList.forEach(System.out::println);
		Pipeline pipeline = jedis.pipelined();
		pipeline.setnx("random:" + UUID.randomUUID(), "random:value:" + UUID.randomUUID());
		pipeline.setnx("random:" + UUID.randomUUID(), "random:value:" + UUID.randomUUID());
		pipeline.setnx("random:" + UUID.randomUUID(), "random:value:" + UUID.randomUUID());
		pipeline.setnx("random:" + UUID.randomUUID(), "random:value:" + UUID.randomUUID());
		pipeline.setnx("random:" + UUID.randomUUID(), "random:value:" + UUID.randomUUID());
		pipeline.get("beijing");
		pipeline.srandmember("configCache", 3);
		pipeline.get("shanghai");
		pipeline.get("configCache4ye-config");
		pipeline.get("guangzhou");
		List<Object> pipelineList = pipeline.syncAndReturnAll();
		pipelineList.forEach(System.out::println);
		jedis.close();
		jedisPool.close();
	}

	@Test
	public void testTwo() {
		HashSet<HostAndPort> hostAndPortHashSet = Sets.newHashSet(HostAndPort.from("10.40.139.214:7001"), HostAndPort.from("10.40.139.214:7002"), HostAndPort.from("10.40.139.214:7003"), HostAndPort.from("10.40.139.214:7004"), HostAndPort.from("10.40.139.214:7005"), HostAndPort.from("10.40.139.214:7006"));
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		JedisCluster jedisCluster = new JedisCluster(hostAndPortHashSet, 10 * 1000, 2 * 1000, 5, "redis", jedisPoolConfig);
//		Long resultNum = jedisCluster.msetnx("beijing", "china", "shanghai", "china", "guangzhou", "china");
//		System.out.println("resultNum = " + resultNum);
//		List<String> resultList = jedisCluster.mget("beijing", "shanghai", "guangzhou");
//		resultList.forEach(System.out::println);
		jedisCluster.setnx("beijing", "china");
		System.out.println(jedisCluster.get("beijing"));
		jedisCluster.setnx("shanghai", "china");
		System.out.println(jedisCluster.get("beijing"));
		jedisCluster.setnx("guangzhou", "china");
		System.out.println(jedisCluster.get("beijing"));
		System.out.println(JedisClusterCRC16.getCRC16("beijing"));
		System.out.println(JedisClusterCRC16.getCRC16("shanghai"));
		System.out.println(JedisClusterCRC16.getCRC16("guangzhou"));
		System.out.println("---------------------------------------------------");
		System.out.println(JedisClusterCRC16.getSlot("beijing"));
		System.out.println(JedisClusterCRC16.getSlot("shanghai"));
		System.out.println(JedisClusterCRC16.getSlot("guangzhou"));
	}

	@Test
	public void testThree() {
		HashSet<HostAndPort> hostAndPortHashSet = Sets.newHashSet(HostAndPort.from("10.40.139.214:7001"), HostAndPort.from("10.40.139.214:7002"), HostAndPort.from("10.40.139.214:7003"), HostAndPort.from("10.40.139.214:7004"), HostAndPort.from("10.40.139.214:7005"), HostAndPort.from("10.40.139.214:7006"));
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		JedisCluster jedisCluster = new JedisCluster(hostAndPortHashSet, 10 * 1000, 2 * 1000, 5, "redis", jedisPoolConfig);
		ScanParams scanParams = new ScanParams();
		scanParams.match("*").count(2);
//		ScanResult<String> scanResult = jedisCluster.scan("0", scanParams);
//		scanResult.getResult().forEach(System.out::println);
		Map<String, JedisPool> jedisPoolMap = jedisCluster.getClusterNodes();
		jedisPoolMap.forEach((k, jedisPool) -> {
			Jedis jedis = jedisPool.getResource();
			System.out.println(k);
			// System.out.println(jedis.info("replication"));
			if (jedis.info("replication").contains("role:master")) {
				List<String> result = jedis.scan("0", scanParams).getResult();
				Optional.ofNullable(result).ifPresent(System.out::println);
			}
			System.out.println("---------------------------------------");
		});
	}

	@Test
	public void testFive() {
		HashSet<HostAndPort> hostAndPortHashSet = Sets.newHashSet(HostAndPort.from("10.40.139.214:7001"), HostAndPort.from("10.40.139.214:7002"), HostAndPort.from("10.40.139.214:7003"), HostAndPort.from("10.40.139.214:7004"), HostAndPort.from("10.40.139.214:7005"), HostAndPort.from("10.40.139.214:7006"));
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		JedisCluster jedisCluster = new JedisCluster(hostAndPortHashSet, 10 * 1000, 2 * 1000, 5, "redis", jedisPoolConfig);
		Map<String, JedisPool> jedisPoolMap = jedisCluster.getClusterNodes();

	}

}
