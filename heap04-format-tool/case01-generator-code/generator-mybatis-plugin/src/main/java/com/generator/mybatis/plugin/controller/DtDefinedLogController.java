package com.generator.mybatis.plugin.controller;

import com.generator.mybatis.plugin.entity.DtDefinedLog;
import com.generator.mybatis.plugin.service.DtDefinedLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 日志记录表(DtDefinedLog)表控制层
 *
 * @author makejava
 * @since 2020-11-01 00:05:05
 */
@RestController
@RequestMapping("dtDefinedLog")
public class DtDefinedLogController {
    /**
     * 服务对象
     */
    @Resource
    private DtDefinedLogService dtDefinedLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DtDefinedLog selectOne(Integer id) {
        return this.dtDefinedLogService.queryById(id);
    }

}