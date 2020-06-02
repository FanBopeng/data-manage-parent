-- 产品表

CREATE TABLE `vc_product_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `product_sort` varchar(20) DEFAULT '' COMMENT '产品分类',
  `product_name` varchar(50) DEFAULT '' COMMENT '产品名称',
  `inventory` int(11) DEFAULT '0' COMMENT '库存剩余',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '单价',
  `total_sales` int(11) DEFAULT '0' COMMENT '销售总量',
  `sales_amount` decimal(10,2) DEFAULT '0.00' COMMENT '销售总额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品信息表';

INSERT INTO `vc_product_info` (`id`, `product_sort`, `product_name`, `inventory`, `price`, `total_sales`, `sales_amount`, `create_time`) VALUES ('1', '数码产品', '平板电脑', '99', '199.78', '100', '19978.00', '2020-05-23 14:49:41');
INSERT INTO `vc_product_info` (`id`, `product_sort`, `product_name`, `inventory`, `price`, `total_sales`, `sales_amount`, `create_time`) VALUES ('2', '数码产品', '手机', '199', '299.78', '100', '29978.00', '2020-05-23 14:50:24');
INSERT INTO `vc_product_info` (`id`, `product_sort`, `product_name`, `inventory`, `price`, `total_sales`, `sales_amount`, `create_time`) VALUES ('3', '编程书籍', 'Java书籍', '59', '59.78', '100', '5978.00', '2020-05-23 14:51:23');
INSERT INTO `vc_product_info` (`id`, `product_sort`, `product_name`, `inventory`, `price`, `total_sales`, `sales_amount`, `create_time`) VALUES ('4', '编程书籍', 'C++书籍', '69', '69.78', '100', '6978.00', '2020-05-23 14:52:10');
INSERT INTO `vc_product_info` (`id`, `product_sort`, `product_name`, `inventory`, `price`, `total_sales`, `sales_amount`, `create_time`) VALUES ('5', '生活家电', '智能电视', '299', '399.78', '100', '39978.00', '2020-05-23 14:53:26');
INSERT INTO `vc_product_info` (`id`, `product_sort`, `product_name`, `inventory`, `price`, `total_sales`, `sales_amount`, `create_time`) VALUES ('6', '生活家电', '语音音箱', '399', '599.78', '100', '59978.00', '2020-05-23 14:54:33');

-- 产品维度

CREATE TABLE `vc_product_detail` (
	`id` INT (11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
	`product_id` INT (11) NOT NULL COMMENT '产品ID',
	`place_origin` VARCHAR (50) DEFAULT '' COMMENT '产品产地',
	`weight` DECIMAL (10, 2) DEFAULT '0.00' COMMENT '重量',
	`color` VARCHAR (50) DEFAULT '' COMMENT '颜色',
	`high_praise` INT (11) DEFAULT '0' COMMENT '好评数量',
	`low_praise` INT (11) DEFAULT '0' COMMENT '差评数量',
	`create_time` datetime DEFAULT NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '产品维度表';

INSERT INTO `vc_product_detail` (`id`, `product_id`, `place_origin`, `weight`, `color`, `high_praise`, `low_praise`, `create_time`) VALUES ('1', '1', '广东', '1.30', '白色', '176', '19', '2020-05-25 11:09:51');
INSERT INTO `vc_product_detail` (`id`, `product_id`, `place_origin`, `weight`, `color`, `high_praise`, `low_praise`, `create_time`) VALUES ('2', '2', '北京', '0.30', '黑色', '1782', '31', '2020-05-25 11:10:29');
INSERT INTO `vc_product_detail` (`id`, `product_id`, `place_origin`, `weight`, `color`, `high_praise`, `low_praise`, `create_time`) VALUES ('3', '3', '成都', '1.60', '蓝色', '698', '14', '2020-05-25 11:11:17');
INSERT INTO `vc_product_detail` (`id`, `product_id`, `place_origin`, `weight`, `color`, `high_praise`, `low_praise`, `create_time`) VALUES ('4', '4', '海外', '1.20', '灰色', '192', '6', '2020-05-25 11:13:02');
INSERT INTO `vc_product_detail` (`id`, `product_id`, `place_origin`, `weight`, `color`, `high_praise`, `low_praise`, `create_time`) VALUES ('5', '5', '南京', '23.60', '墨色', '1099', '23', '2020-05-25 11:13:56');
INSERT INTO `vc_product_detail` (`id`, `product_id`, `place_origin`, `weight`, `color`, `high_praise`, `low_praise`, `create_time`) VALUES ('6', '6', '杭州', '1.10', '橙色', '392', '12', '2020-05-25 11:14:38');
