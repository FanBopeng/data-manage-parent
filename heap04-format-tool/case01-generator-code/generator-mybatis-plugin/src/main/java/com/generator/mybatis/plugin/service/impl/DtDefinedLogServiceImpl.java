package com.generator.mybatis.plugin.service.impl;

import com.generator.mybatis.plugin.entity.DtDefinedLog;
import com.generator.mybatis.plugin.dao.DtDefinedLogDao;
import com.generator.mybatis.plugin.service.DtDefinedLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日志记录表(DtDefinedLog)表服务实现类
 *
 * @author makejava
 * @since 2020-11-01 00:05:04
 */
@Service("dtDefinedLogService")
public class DtDefinedLogServiceImpl implements DtDefinedLogService {
    @Resource
    private DtDefinedLogDao dtDefinedLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DtDefinedLog queryById(Integer id) {
        return this.dtDefinedLogDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DtDefinedLog> queryAllByLimit(int offset, int limit) {
        return this.dtDefinedLogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dtDefinedLog 实例对象
     * @return 实例对象
     */
    @Override
    public DtDefinedLog insert(DtDefinedLog dtDefinedLog) {
        this.dtDefinedLogDao.insert(dtDefinedLog);
        return dtDefinedLog;
    }

    /**
     * 修改数据
     *
     * @param dtDefinedLog 实例对象
     * @return 实例对象
     */
    @Override
    public DtDefinedLog update(DtDefinedLog dtDefinedLog) {
        this.dtDefinedLogDao.update(dtDefinedLog);
        return this.queryById(dtDefinedLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dtDefinedLogDao.deleteById(id) > 0;
    }
}