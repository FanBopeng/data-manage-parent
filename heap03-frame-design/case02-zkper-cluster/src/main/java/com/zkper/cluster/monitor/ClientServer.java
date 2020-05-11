package com.zkper.cluster.monitor;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientServer {
    private ZooKeeper zk ;
    private static final String connectString = "127.0.0.133:2181,127.0.0.136:2181,127.0.0.137:2181";
    private static final int sessionTimeout = 3000;
    private static final String parentNode = "/serverList";

    private void getConnect() throws IOException {
        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                try {
                    // 监听在线的服务列表
                    getServerList();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void getServerList() throws Exception {
        List<String> children = zk.getChildren(parentNode, true);
        List<String> servers = new ArrayList<>();
        for (String child : children) {
            byte[] data = zk.getData(parentNode + "/" + child, false, null);
            servers.add(new String(data));
        }
        System.out.println("当前服务列表："+servers);
    }

    private void working() throws Exception{
        Thread.sleep(Long.MAX_VALUE);
    }

    public static void main(String[] args) throws Exception {
        ClientServer client = new ClientServer();
        client.getConnect();
        client.getServerList();
        client.working();
    }

}
