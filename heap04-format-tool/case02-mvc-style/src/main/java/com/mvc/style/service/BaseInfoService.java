package com.mvc.style.service;

import com.mvc.style.dao.BaseInfoDao;
import com.mvc.style.dao.DetailInfoDao;
import com.mvc.style.entity.BaseInfo;
import com.mvc.style.entity.BaseInfoExample;
import com.mvc.style.entity.DetailInfoEntity;
import com.mvc.style.model.InfoModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BaseInfoService {

    private static Logger LOG = LoggerFactory.getLogger(BaseInfoService.class);

    @Resource
    private BaseInfoDao baseInfoDao ;
    @Resource
    private DetailInfoDao detailInfoDao ;

    public int insert (BaseInfo record){
        record.setCreateTime(new Date());
        int insertFlag = baseInfoDao.insert(record);
        if (insertFlag > 0){
            DetailInfoEntity detailInfoEntity = new DetailInfoEntity();
            detailInfoEntity.setUserId(record.getId());
            detailInfoEntity.setCreateTime(record.getCreateTime());
            if(detailInfoDao.save(detailInfoEntity)){
                return insertFlag ;
            }
        }
        return insertFlag;
    }

    public List<BaseInfo> list(BaseInfoExample example){
        return baseInfoDao.selectByExample(example);
    }

    public List<BaseInfo> search (String userName,String phone){
        BaseInfoExample example = new BaseInfoExample();
        example.createCriteria().andUserNameEqualTo(userName).andPhoneEqualTo(phone);
        return baseInfoDao.selectByExample(example);
    }

    public int update (BaseInfo baseInfo){
        return baseInfoDao.updateByPrimaryKey(baseInfo);
    }

    public InfoModel detail(Integer id){
        BaseInfo baseInfo = baseInfoDao.selectByPrimaryKey(id) ;
        if (baseInfo != null){
            DetailInfoEntity detailInfoEntity = detailInfoDao.getById(id);
            if (detailInfoEntity == null){
                LOG.info("id="+id+"数据缺失 DetailInfo");
            }
            return buildModel(baseInfo,detailInfoEntity) ;
        }
        LOG.info("id="+id+"数据完全缺失");
        return null ;
    }

    private InfoModel buildModel (BaseInfo baseInfo,DetailInfoEntity detailInfo){
        InfoModel infoModel = new InfoModel() ;
        infoModel.setBaseInfo(baseInfo);
        infoModel.setDetailInfoEntity(detailInfo);
        return infoModel ;
    }

    public void delete(Integer id){
        baseInfoDao.deleteByPrimaryKey(id);
        detailInfoDao.removeById(id);
    }

    public BaseInfo getById (Integer id) {
        return baseInfoDao.getById(id);
    }
}
