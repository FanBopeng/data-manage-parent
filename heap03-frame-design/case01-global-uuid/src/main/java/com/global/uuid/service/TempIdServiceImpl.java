package com.global.uuid.service;

import com.global.uuid.entity.TempIdEntity;
import com.global.uuid.mapper.TempIdMapper;
import com.global.uuid.utils.UuidUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TempIdServiceImpl implements TempIdService {

    @Resource
    private TempIdMapper tempIdMapper ;

    @Override
    public List<String> getIdList() {
        List<String> idList = new ArrayList<>() ;
        TempIdEntity tempIdEntity = new TempIdEntity ();
        tempIdEntity.setCreateTime(new Date());
        for (int i = 0 ; i < 10 ; i++){
            tempIdMapper.insert(tempIdEntity);
            idList.add(UuidUtil.getNoId(8,Long.parseLong(tempIdEntity.getId().toString()))) ;
        }
        return idList ;
    }

    @Override
    public List<String> getRouteIdList() {
        List<String> idList = new ArrayList<>() ;
        TempIdEntity tempIdEntity = new TempIdEntity ();
        tempIdEntity.setCreateTime(new Date());
        for (int i = 0 ; i < 2 ; i++){
            tempIdMapper.insertA(tempIdEntity);
            idList.add(UuidUtil.getRouteId("UID-A",10,
                       Long.parseLong(tempIdEntity.getId().toString()))) ;
            tempIdMapper.insertB(tempIdEntity);
            idList.add(UuidUtil.getRouteId("UID-B",10,
                    Long.parseLong(tempIdEntity.getId().toString()))) ;
            tempIdMapper.insertC(tempIdEntity);
            idList.add(UuidUtil.getRouteId("UID-C",10,
                    Long.parseLong(tempIdEntity.getId().toString()))) ;
        }
        return idList ;
    }
}
