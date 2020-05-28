CREATE TABLE `cr_key_value` (
	`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`cache_key` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '缓存key',
	`cache_value` VARCHAR (200) NOT NULL DEFAULT '' COMMENT '缓存value',
	`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT NULL COMMENT '更新时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '缓存管理表';