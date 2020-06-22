CREATE TABLE `dl_data_lock` (
	`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`inventory` INT (11) DEFAULT '0' COMMENT '库存量',
	`lock_value` INT (11) NOT NULL DEFAULT '0' COMMENT '锁版本',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '锁机制表';

INSERT INTO `data-lock`.`dl_data_lock` (`id`, `inventory`, `lock_value`) VALUES ('1', '100', '0');
