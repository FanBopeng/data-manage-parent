CREATE TABLE `dp_order_state` (
	`order_id` BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
	`token_id` VARCHAR (50) DEFAULT NULL COMMENT '防重复提交',
	`state` INT (1) DEFAULT '1' COMMENT '1创建订单，2本地业务，3支付业务',
	PRIMARY KEY (`order_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '订单状态表';

CREATE TABLE `dp_state_record` (
	`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`order_id` BIGINT (20) NOT NULL COMMENT '订单id',
	`state_dec` VARCHAR (50) DEFAULT NULL COMMENT '状态描述',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '状态记录表';