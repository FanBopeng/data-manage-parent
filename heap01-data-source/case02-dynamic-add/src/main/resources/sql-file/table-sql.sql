CREATE TABLE `jm_connection` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `data_type_name` varchar(100) DEFAULT NULL COMMENT '数据源类型名称',
  `driver_class_name` varchar(100) DEFAULT NULL COMMENT '驱动',
  `jdbc_url` varchar(100) DEFAULT NULL COMMENT '服务地址',
  `user_name` varchar(100) DEFAULT NULL COMMENT '连接账户',
  `pass_word` varchar(100) DEFAULT NULL COMMENT '连接密码',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `state` int(2) DEFAULT '1' COMMENT '状态：1可用，2不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='数据源连接表';