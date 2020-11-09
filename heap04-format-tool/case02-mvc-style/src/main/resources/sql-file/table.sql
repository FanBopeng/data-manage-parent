CREATE TABLE `ms_base_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(20) NOT NULL COMMENT '用户名称',
  `card_id` varchar(30) DEFAULT '' COMMENT '身份编号',
  `phone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(150) DEFAULT NULL COMMENT '备注',
  `state` int(1) DEFAULT '1' COMMENT '状态1启用,2禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='基础信息';

CREATE TABLE `ms_detail_info` (
	`user_id` INT (11) NOT NULL COMMENT '主键ID',
	`province` VARCHAR (30) DEFAULT '' COMMENT '省份',
	`city` VARCHAR (30) DEFAULT '' COMMENT '城市',
	`county` VARCHAR (15) DEFAULT NULL COMMENT '县城',
	`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT NULL COMMENT '更新时间',
	`remark` VARCHAR (150) DEFAULT NULL COMMENT '备注',
	`state` INT (1) DEFAULT '1' COMMENT '状态1启用,2禁用',
	PRIMARY KEY (`user_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '详情表';