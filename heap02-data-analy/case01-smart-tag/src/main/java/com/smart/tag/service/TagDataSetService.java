package com.smart.tag.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.tag.entity.TagDataSet;
import com.smart.tag.entity.TagParam;
import java.util.List;

public interface TagDataSetService extends IService<TagDataSet> {

    Integer analyze (List<TagParam> tagParamList);

}
