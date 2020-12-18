package com.song.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @ClassName ZkTets1
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-16 23:06
 */
public class ZkTets1 implements Watcher {

    private ZooKeeper zookeeper;

    private String host;

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("watcher");
    }

    public ZkTets1(String host) {
        this.host = host;
    }

    void startZk() throws IOException {
        zookeeper = new ZooKeeper(host,15000,this);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ZkTets1 zk = new ZkTets1("127.0.0.1:2181");
        zk.startZk();
        Thread.sleep(10000);

    }
}
