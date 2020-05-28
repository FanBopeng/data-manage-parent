package com.cache.redis.entity;

import java.util.Properties;

public class MonitorEntity {

    private String monitorParam ;
    private Properties properties ;

    public String getMonitorParam() {
        return monitorParam;
    }

    public void setMonitorParam(String monitorParam) {
        this.monitorParam = monitorParam;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
