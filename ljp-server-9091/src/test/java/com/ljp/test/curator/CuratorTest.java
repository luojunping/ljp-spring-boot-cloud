package com.ljp.test.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CuratorTest {

	public static void main(String[] args) throws Exception {
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("10.40.139.214:2181", 300 * 1000,
				60 * 1000, new RetryNTimes(10, 60000));
		curatorFramework.start();
		curatorFramework.blockUntilConnected();
		List<String> pathList = curatorFramework.getChildren().usingWatcher((CuratorWatcher) event -> {
			Watcher.Event.KeeperState keeperState = event.getState();
			if (Watcher.Event.KeeperState.Disconnected == keeperState) {
				System.out.println("keeperState.getIntValue() = " + keeperState.getIntValue());
			}
		}).forPath("/");
		System.out.println("pathList = " + pathList);
	}

	@Test
	public void testOne() throws Exception {
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("10.40.139.214:2181", new RetryNTimes(10, 10 * 1000));
		curatorFramework.start();
		curatorFramework.blockUntilConnected();
		Stat stat = curatorFramework.checkExists().forPath("/test/hello/world");
		if (stat == null) {
			String helloWorld = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/test/hello/world", "Hello World !!!".getBytes(StandardCharsets.UTF_8));
			System.out.println("helloWorld = " + helloWorld);
		}
	}

	@Test
	public void testTwo() throws Exception {
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("10.40.139.214:2181", new RetryNTimes(10, 10 * 1000));
		curatorFramework.start();
		curatorFramework.blockUntilConnected();
		curatorFramework.delete().guaranteed().withVersion(-1).forPath("/test/hello/world");
	}

	@Test
	public void testThree() throws Exception {
		// System.out.println(10 % 3);
		System.out.println(2 << 3);
		System.out.println(16 >>> 5);
		System.out.println(2 & 3);
		System.out.println(2 | 3);
		System.out.println(2 ^ 3);
		System.out.println(1 + 'A');
		int maxValue = Integer.MAX_VALUE;
		System.out.println(100 * maxValue);
	}

	@Test
	public void testFour() throws Exception {
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("10.40.139.214:2181", 60 * 1000, 10 * 1000, new ExponentialBackoffRetry(1000, 10, 5 * 1000));
		curatorFramework.start();
		curatorFramework.blockUntilConnected();
		CuratorCache curatorCache = CuratorCache.builder(curatorFramework, "/").build();
		CuratorCacheListener curatorCacheListener = CuratorCacheListener.builder().forAll((type, oldData, data) -> {
			// System.out.println("type=" + type.name() + ",oldData=" + oldData + ",data=" + data);
		}).build();
		curatorCache.listenable().addListener(curatorCacheListener);
		curatorCache.start();
		String helloWorld = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath("/test/hello/world/1", "hello world !!!".getBytes(StandardCharsets.UTF_8));
		System.out.println("helloWorld = " + helloWorld);
		String helloChina = curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/test/hello/china/1", "hello china !!!".getBytes(StandardCharsets.UTF_8));
		System.out.println("helloChina = " + helloChina);
//		System.out.println("curatorCache.get(\"/test/hello/world\") = " + curatorCache.get("/test/hello/world"));
//		curatorFramework.delete().guaranteed().deletingChildrenIfNeeded().forPath("/test/hello/world");
//		System.out.println("curatorCache.get(\"/test/hello/world\") = " + curatorCache.get("/test/hello/world"));
		byte[] bytes = curatorFramework.getData().forPath("/test/hello/world/1");
//		System.out.println(new String(bytes, StandardCharsets.UTF_8));

	}

	@Test
	public void testFive() throws InterruptedException {
		String h1 = "hello";
		String h2 = "hello";
		System.out.println(h1 == h2);
		new Thread(() -> {
			String h3 = "hello";
			System.out.println(Thread.currentThread().getName() + "=" + (h1 == h3));
			String h4 = h3.intern();
			System.out.println(Thread.currentThread().getName() + "=" + (h3 == h4));
			String h5 = "hello";
			System.out.println(Thread.currentThread().getName() + "=" + (h3 == h5));
		}, "newThread").start();
		TimeUnit.SECONDS.sleep(1);
	}

}
