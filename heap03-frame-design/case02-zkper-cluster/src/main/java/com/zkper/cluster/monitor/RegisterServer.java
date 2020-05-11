package com.zkper.cluster.monitor;

import java.io.IOException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooDefs.Ids;

public class RegisterServer {

    private ZooKeeper zk ;
    private static final String connectString = "127.0.0.133:2181,127.0.0.136:2181,127.0.0.137:2181";
    private static final int sessionTimeout = 3000;
    private static final String parentNode = "/serverList";

    private void getConnect() throws IOException{
        zk = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
            }
        });
    }

    private void registerServer(String nodeName) throws Exception{
        String create = zk.create(parentNode + "/server", nodeName.getBytes(),
                                  Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(nodeName +" 上线："+ create);
    }

    private void working() throws Exception{

        Thread.sleep(Long.MAX_VALUE);
    }

    public static void main(String[] args) throws Exception {
        RegisterServer server = new RegisterServer();
        server.getConnect();
        // 分别启动三次服务，注册不同节点，再一次关闭不同服务端看客户端效果
        // server.registerServer("zk-node-133");
        // server.registerServer("zk-node-136");
        server.registerServer("zk-node-137");
        server.working();
    }
}
