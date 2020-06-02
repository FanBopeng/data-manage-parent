package com.visual.chart.service.impl;

import com.visual.chart.entity.ChartParam;
import com.visual.chart.entity.DataSetEntity;
import com.visual.chart.mapper.DataSetMapper;
import com.visual.chart.service.DataSetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DataSetServiceImpl implements DataSetService {

    @Resource
    private DataSetMapper dataSetMapper ;

    @Override
    public List<DataSetEntity> findAll() {
        return dataSetMapper.findAll();
    }
    // 分析任务划分
    @Override
    public Map<Integer, List<ChartParam>> analyData(List<ChartParam> chartParamList) {
        Map<Integer, List<ChartParam>> dataMap = chartParamList.stream()
                                                 .collect(Collectors
                                                 .groupingBy(ChartParam::getDataType));
        for (Integer dataType:dataMap.keySet()){
            switch (dataType){
                case 1: // Count 风格数据
                    taskCount(dataMap.get(dataType));
                    break;
                case 2: // Sum 风格数据
                    taskSum(dataMap.get(dataType));
                    break;
                case 3: // Percent 风格数据
                    taskPercent(dataMap.get(dataType));
                    break;
                default:
                    break;
            }
        }
        return dataMap ;
    }
    // Count 数据执行
    private void taskCount (List<ChartParam> chartParamList){
        for (ChartParam chartParam:chartParamList){
            chartParam.setResultNum(dataSetMapper.taskCount(chartParam.getColumnName(),
                                                            chartParam.getTableName()));
        }
    }
    // Sum 数据执行
    private void taskSum (List<ChartParam> chartParamList){
        for (ChartParam chartParam:chartParamList){
            chartParam.setResultNum(dataSetMapper.taskSum(chartParam.getColumnName(),
                                                          chartParam.getTableName()));
        }
    }
    // Percent 数据执行
    private void taskPercent (List<ChartParam> chartParamList){
        for (ChartParam chartParam:chartParamList){
            chartParam.setResultNum(dataSetMapper.taskPercent(chartParam.getColumnName(),
                                                              chartParam.getTableName(),
                                                              chartParam.getProductId()));
        }
    }
}
