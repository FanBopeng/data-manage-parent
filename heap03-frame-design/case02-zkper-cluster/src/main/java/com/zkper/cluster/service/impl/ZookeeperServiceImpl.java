package com.zkper.cluster.service.impl;

import com.zkper.cluster.config.ZookeeperConfig;
import com.zkper.cluster.service.ZookeeperService;
import org.apache.commons.lang.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ZookeeperServiceImpl implements ZookeeperService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperServiceImpl.class);

    @Override
    public boolean isExistNode(String path) {
        CuratorFramework client = ZookeeperConfig.getClient();
        client.sync() ;
        try {
            Stat stat = client.checkExists().forPath(path);
            return client.checkExists().forPath(path) != null;
        } catch (Exception e) {
            LOGGER.error("isExistNode error...", e);
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getNodeData(String path) {
        CuratorFramework client = ZookeeperConfig.getClient() ;
        try {
            // 数据读取和转换
            byte[] dataByte = client.getData().forPath(path) ;
            String data = new String(dataByte,"UTF-8") ;
            if (StringUtils.isNotEmpty(data)){
                return data ;
            }
        }catch (Exception e) {
            LOGGER.error("getNodeData error...", e);
            e.printStackTrace();
        }
        return null;
    }
}