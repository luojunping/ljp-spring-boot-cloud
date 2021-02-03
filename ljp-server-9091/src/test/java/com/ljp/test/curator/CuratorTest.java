package com.ljp.test.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.Watcher;

import java.util.List;

public class CuratorTest {

	public static void main(String[] args) throws Exception {
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("10.40.139.214:2181", 300 * 1000,
				600 * 1000, new RetryNTimes(10, 60000));
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

}
