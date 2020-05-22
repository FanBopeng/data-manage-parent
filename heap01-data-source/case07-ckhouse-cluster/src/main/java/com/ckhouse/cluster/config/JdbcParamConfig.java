package com.ckhouse.cluster.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@ConfigurationProperties(prefix = "spring.datasource.click")
public class JdbcParamConfig {

    private String driverClassName ;
    private String url ;
    private String cluster ;
    private Integer initialSize ;
    private Integer maxActive ;
    private Integer minIdle ;
    private Integer maxWait ;

    public String[] getUrlArray (){
        if (!StringUtils.isEmpty(url) && url.contains(",")){
            return this.url.split(",");
        }
        return new String[]{url};
    }

    public String getDriverClassName() {
        return driverClassName;
    }
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getCluster() {
        return cluster;
    }
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
    public Integer getInitialSize() {
        return initialSize;
    }
    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }
    public Integer getMaxActive() {
        return maxActive;
    }
    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }
    public Integer getMinIdle() {
        return minIdle;
    }
    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }
    public Integer getMaxWait() {
        return maxWait;
    }
    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }
}