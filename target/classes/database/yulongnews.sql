DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户ID号',
  `user_password` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `user_group` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户组 -- 可能值（管理员， 合作方，个人用户，公司用户）',
  `user_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '姓名',
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电子邮件',
  `phone_num` decimal(12,0) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `zip_code` decimal(10,0) DEFAULT NULL COMMENT '邮编',
  `user_status` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '审核状态 1-通过， 0-未通过',
  `valid_code` varchar(15) COLLATE utf8_unicode_ci DEFAULT '',
  `is_close` char(1) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `pk_t_user_info_0` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户信息表';