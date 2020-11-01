package com.generator.mybatis.plugin.service;

import com.generator.mybatis.plugin.entity.DtDefinedLog;
import java.util.List;

/**
 * 日志记录表(DtDefinedLog)表服务接口
 *
 * @author makejava
 * @since 2020-11-01 00:05:03
 */
public interface DtDefinedLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DtDefinedLog queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DtDefinedLog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dtDefinedLog 实例对象
     * @return 实例对象
     */
    DtDefinedLog insert(DtDefinedLog dtDefinedLog);

    /**
     * 修改数据
     *
     * @param dtDefinedLog 实例对象
     * @return 实例对象
     */
    DtDefinedLog update(DtDefinedLog dtDefinedLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}