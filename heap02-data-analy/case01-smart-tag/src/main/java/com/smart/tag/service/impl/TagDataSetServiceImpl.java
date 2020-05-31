package com.smart.tag.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.tag.entity.TagDataSet;
import com.smart.tag.entity.TagParam;
import com.smart.tag.mapper.TagDataSetMapper;
import com.smart.tag.service.TagDataSetService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class TagDataSetServiceImpl extends ServiceImpl<TagDataSetMapper, TagDataSet> implements TagDataSetService {

    @Resource
    private TagDataSetMapper tagDataSetMapper ;

    @Override
    public Integer analyze(List<TagParam> tagParamList) {
        StringBuffer querySQL = new StringBuffer() ;
        for (TagParam tagParam:tagParamList){
            querySQL.append(" AND ") ;
            querySQL.append(tagParam.getBindColumn()) ;
            // 1枚举,2数值,3日期,4布尔,5值类型
            List<String> valueList = tagParam.getValueList();
            switch (tagParam.getDataType()){
                case 1:
                    querySQL.append(" IN (") ;
                    for (int i = 0 ; i < valueList.size() ;i++){
                        if (i != valueList.size()-1){
                            querySQL.append("'").append(valueList.get(i)).append("',");
                        } else {
                            querySQL.append("'").append(valueList.get(i)).append("'");
                        }
                    }
                    querySQL.append(" )") ;
                    break;
                case 2:
                    querySQL.append("=").append(tagParam.getValueList().get(0)) ;
                    break;
                case 3:
                    querySQL.append(">='").append(tagParam.getValueList().get(0)).append("'") ;
                    break;
                case 4:
                    querySQL.append("=").append(tagParam.getValueList().get(0)) ;
                    break;
                case 5:
                    querySQL.append(" LIKE '%").append(tagParam.getValueList().get(0)).append("%'") ;
                    break;
                default:
                    break;
            }
        }
        /* 最终执行的 SQL
            SELECT COUNT(*) FROM tc_tag_data_set
            WHERE 1 = 1
            AND origin_place IN ('深圳', '广东')
            AND unit_price = 1999
            AND create_time >= '2020-05-01 13:43:54'
            AND is_shelves = 1
            AND product_name LIKE '%智能%'
         */
        String whereCondition = String.valueOf(querySQL);
        return tagDataSetMapper.analyze(whereCondition);
    }
}
