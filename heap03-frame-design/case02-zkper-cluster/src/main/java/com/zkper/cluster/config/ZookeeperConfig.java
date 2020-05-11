package com.zkper.cluster.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


@Configuration
public class ZookeeperConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperConfig.class) ;

    @Resource
    private ZookeeperParam zookeeperParam ;

    private static CuratorFramework client = null ;

    /**
     * 初始化
     */
    @PostConstruct
    public void init (){
        //重试策略，初试时间1秒，重试10次
        RetryPolicy policy = new ExponentialBackoffRetry(
                zookeeperParam.getBaseSleepTimeMs(),
                zookeeperParam.getMaxRetries());
        //通过工厂创建Curator
        client = CuratorFrameworkFactory.builder()
                .connectString(zookeeperParam.getServer())
                //.authorization("digest",zookeeperParam.getDigest().getBytes())
                .connectionTimeoutMs(zookeeperParam.getConnectionTimeoutMs())
                .sessionTimeoutMs(zookeeperParam.getSessionTimeoutMs())
                .retryPolicy(policy).build();
        //开启连接
        client.start();
        LOGGER.info("zookeeper 初始化完成...");
    }

    public static CuratorFramework getClient (){
        return client ;
    }

    public static void closeClient (){
        if (client != null){
            client.close();
        }
    }
}