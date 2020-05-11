package com.zkper.cluster.service;

import java.util.List;

public interface ZookeeperService {
    /**
     * 判断节点是否存在
     */
    boolean isExistNode (final String path) ;

    /**
     * 获取节点数据
     */
    String getNodeData (String path) ;
}