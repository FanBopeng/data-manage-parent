CREATE TABLE `tc_tag_catalog` (
	`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`catalog_name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '名称',
	`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT NULL COMMENT '更新时间',
	`state` INT (1) DEFAULT '1' COMMENT '状态1启用,2禁用',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '标签层级目录';

CREATE TABLE `tc_tag_cloud` (
	`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`catalog_id` INT (11) NOT NULL COMMENT '目录ID',
	`tag_name` VARCHAR (100) DEFAULT '' COMMENT '标签名称',
	`tag_code` INT (11) DEFAULT NULL COMMENT '标签编码',
	`bind_column` VARCHAR (100) DEFAULT '' COMMENT '绑定数据列',
	`data_type` INT (2) NOT NULL COMMENT '1枚举,2数值,3日期,4布尔,5值类型',
	`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` datetime DEFAULT NULL COMMENT '更新时间',
	`remark` VARCHAR (150) DEFAULT NULL COMMENT '备注',
	`state` INT (1) DEFAULT '1' COMMENT '状态1启用,2禁用',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '标签云';

CREATE TABLE `tc_tag_data_enum` (
	`tag_code` INT (11) NOT NULL COMMENT '标签编码',
	`data_value` VARCHAR (150) NOT NULL COMMENT '枚举值',
	`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	KEY `tag_code_index` (`tag_code`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '标签枚举值';

CREATE TABLE `tc_tag_data_set` (
	`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`product_name` VARCHAR (100) DEFAULT '' COMMENT '商品名称',
	`unit_price` DECIMAL (10, 2) DEFAULT '0.00' COMMENT '单价',
	`is_shelves` INT (1) DEFAULT '1' COMMENT '是否上架：1否,2是',
	`origin_place` VARCHAR (100) DEFAULT '' COMMENT '产地',
	`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '标签数据集';