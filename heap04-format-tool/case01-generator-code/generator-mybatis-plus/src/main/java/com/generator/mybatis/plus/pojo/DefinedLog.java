package com.generator.mybatis.plus.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 日志记录表
 * </p>
 *
 * @author mybatis-plus
 * @since 2020-10-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("dt_defined_log")
public class DefinedLog implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 请求类名
     */
    private String className;

    /**
     * 请求方法名
     */
    private String methodName;

    /**
     * 请求方法描述
     */
    private String methodDesc;

    /**
     * API类型
     */
    private Integer apiType;

    /**
     * 业务性质类型
     */
    private Integer bizNature;

    /**
     * 日志数据流向
     */
    private Integer dataFlowType;

    /**
     * 请求报文
     */
    private String reqParam;

    /**
     * 响应报文
     */
    private String resParam;


}
