package com.assess.biz.entity;

/**
 * 匹配项
 */
public class MatchItem {
    // 城市
    private String city ;
    // 标签
    private String tag ;
    // 基础构造
    public MatchItem(String city, String tag) {
        this.city = city;
        this.tag = tag;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
