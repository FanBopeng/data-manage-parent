package com.smart.tag.controller;

import com.smart.tag.entity.TagParam;
import com.smart.tag.service.TagDataSetService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Api(value = "ConnectionController")
@RestController
public class AnalyzeController {

    @Resource
    private TagDataSetService tagDataSetService ;

    @GetMapping("/analyze")
    public String analyze (){
        List<TagParam> tagParamList = new ArrayList<>() ;

        TagParam tagParam1 = new TagParam(1,"产地","origin_place") ;
        List<String> valueList1 = new ArrayList<>() ;
        valueList1.add("深圳");
        valueList1.add("广东");
        tagParam1.setValueList(valueList1);
        tagParamList.add(tagParam1) ;

        TagParam tagParam2 = new TagParam(2,"价格","unit_price") ;
        List<String> valueList2 = new ArrayList<>() ;
        valueList2.add("1999");
        tagParam2.setValueList(valueList2);
        tagParamList.add(tagParam2) ;

        TagParam tagParam3 = new TagParam(3,"生产日期","create_time") ;
        List<String> valueList3 = new ArrayList<>() ;
        valueList3.add("2020-05-01 13:43:54");
        tagParam3.setValueList(valueList3);
        tagParamList.add(tagParam3) ;

        TagParam tagParam4 = new TagParam(4,"是否上架","is_shelves") ;
        List<String> valueList4 = new ArrayList<>() ;
        valueList4.add("1");
        tagParam4.setValueList(valueList4);
        tagParamList.add(tagParam4) ;

        TagParam tagParam5 = new TagParam(5,"产品名称","product_name") ;
        List<String> valueList5 = new ArrayList<>() ;
        valueList5.add("智能");
        tagParam5.setValueList(valueList5);
        tagParamList.add(tagParam5) ;

        Integer count = tagDataSetService.analyze(tagParamList) ;

        return "Result：" + count ;
    }

}
