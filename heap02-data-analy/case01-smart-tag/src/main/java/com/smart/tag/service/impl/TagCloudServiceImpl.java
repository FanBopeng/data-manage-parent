package com.smart.tag.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.tag.entity.TagCloud;
import com.smart.tag.mapper.TagCloudMapper;
import com.smart.tag.service.TagCloudService;
import org.springframework.stereotype.Service;

@Service
public class TagCloudServiceImpl extends ServiceImpl<TagCloudMapper, TagCloud> implements TagCloudService {

}
