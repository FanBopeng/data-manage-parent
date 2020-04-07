CREATE TABLE `dc_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户名',
  `data_sign` varchar(10) DEFAULT NULL COMMENT '数据标识：master,slave',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模拟数据表';