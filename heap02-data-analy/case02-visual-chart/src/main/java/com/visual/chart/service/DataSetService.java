package com.visual.chart.service;

import com.visual.chart.entity.ChartParam;
import com.visual.chart.entity.DataSetEntity;

import java.util.List;
import java.util.Map;

public interface DataSetService {

    List<DataSetEntity> findAll () ;

    Map<Integer, List<ChartParam>> analyData (List<ChartParam> chartParamList) ;
}
