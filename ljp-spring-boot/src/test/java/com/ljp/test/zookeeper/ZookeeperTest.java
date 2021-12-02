package com.ljp.test.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CreateBuilder;
import org.apache.curator.framework.api.GetDataBuilder;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class ZookeeperTest {

	@Test
	public void testOne() throws Exception {
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("luojunping:2181", new RetryOneTime(30 * 1000));
		curatorFramework.start();
		curatorFramework.blockUntilConnected();
		CreateBuilder createBuilder = curatorFramework.create();
		String helloWorld = createBuilder.creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath("/test/zookeeper/hello/world", "hello world !!!".getBytes(StandardCharsets.UTF_8));
		System.out.println(helloWorld);
		GetDataBuilder getDataBuilder = curatorFramework.getData();
		byte[] bytes = getDataBuilder.forPath("/test/zookeeper/hello/world");
		System.out.println(new String(bytes, StandardCharsets.UTF_8));
		curatorFramework.close();
	}

}
