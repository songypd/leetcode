package com.song.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;

/**
 * @ClassName CuratorFrameworkT
 * @Description Valar Morghulis.Valar Dohaeris
 * @Author songyp
 * @Date 2020-12-17 23:05
 */
public class CuratorFrameworkT {

    private static String connectString = "127.0.0.1:2181";

    public static void main(String[] args) throws Exception {

        CuratorFramework zkc = CuratorFrameworkFactory.newClient(connectString, new RetryOneTime(1000));

        //同步创建的方法
        String s = zkc.create().withMode(CreateMode.PERSISTENT).forPath("/mypath", new byte[0]);
        //异步创建的方法
//        String s1 = zkc.create().inBackground().forPath("/mypath2", new byte[0]);
//        //异步创建监听器
//        zkc.getData().watched().forPath("/mypath");
//
//        CuratorListener listener = new CuratorListener() {
//            @Override
//            public void eventReceived(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
//                System.out.println();
//            }
//        };
    }
}
