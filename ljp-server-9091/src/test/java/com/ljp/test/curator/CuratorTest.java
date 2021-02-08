package com.ljp.test.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
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

}
