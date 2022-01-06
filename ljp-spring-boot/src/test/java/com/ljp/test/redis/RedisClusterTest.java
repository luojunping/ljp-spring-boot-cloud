package com.ljp.test.redis;

import com.google.common.collect.Sets;
import redis.clients.jedis.ConnectionPool;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.params.ScanParams;
import redis.clients.jedis.resps.ScanResult;

import java.util.Map;
import java.util.Set;

public class RedisClusterTest {

    public static void main(String[] args) {
        Set<HostAndPort> hostAndPortSet = Sets.newHashSet(new HostAndPort("luojunping", 7001), new HostAndPort("luojunping", 7002), new HostAndPort("luojunping", 7003), new HostAndPort("luojunping", 7004), new HostAndPort("luojunping", 7005), new HostAndPort("luojunping", 7006));
        DefaultJedisClientConfig defaultJedisClientConfig = DefaultJedisClientConfig.builder().user("admin").password("admin").build();
        JedisCluster jedisCluster = new JedisCluster(hostAndPortSet, defaultJedisClientConfig);
        for (int i = 1; i <= 6; i++) {
            jedisCluster.set("hello-" + i, "world-" + i);
        }
//        Map<String, ConnectionPool> clusterNodes = jedisCluster.getClusterNodes();
//        System.out.println("clusterNodes = " + clusterNodes);
        Map<String, ConnectionPool> clusterNodes = jedisCluster.getClusterNodes();
        ScanParams scanParams = new ScanParams();
        scanParams.match("hello-*").count(100);
        ScanResult<String> scanResult = jedisCluster.scan("0", scanParams);
        scanResult.getResult().forEach(System.out::println);
        System.out.println(jedisCluster.get("hello"));
        jedisCluster.close();

    }

}
