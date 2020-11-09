package com.mvc.style.model;

import com.mvc.style.entity.BaseInfo;
import com.mvc.style.entity.DetailInfoEntity;

public class InfoModel {

    private BaseInfo baseInfo ;
    private DetailInfoEntity detailInfoEntity;

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public DetailInfoEntity getDetailInfoEntity() {
        return detailInfoEntity;
    }

    public void setDetailInfoEntity(DetailInfoEntity detailInfoEntity) {
        this.detailInfoEntity = detailInfoEntity;
    }
}
