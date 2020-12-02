CREATE TABLE `evaluate_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `classify_sign` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '归类标识',
  `rule_value` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '规则描述',
  `rule_type` int(1) DEFAULT NULL COMMENT '规则类型：1精准匹配，2范围，3模糊',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='评估项规则';
