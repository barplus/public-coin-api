-- 系统用户表
CREATE TABLE `t_sys_user` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `login_name` VARCHAR(64) BINARY NOT NULL COMMENT '登录名',
  `login_pass` VARCHAR(64) BINARY NOT NULL COMMENT '登录密码',
  `status` INT NOT NULL DEFAULT '1' COMMENT '用户状态',
  `create_user` VARCHAR(64) BINARY NOT NULL COMMENT '创建人',
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `update_user` VARCHAR(64) BINARY NOT NULL COMMENT '修改人',
  `update_date` DATETIME NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY(login_name)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- 会员表
CREATE TABLE `t_customer` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `login_name` VARCHAR(64) BINARY NOT NULL COMMENT '登录名',
  `login_pass` VARCHAR(64) BINARY COMMENT '登录密码',
  `vip` INT NOT NULL DEFAULT 0 COMMENT 'VIP等级:默认0级',
  `roulette_total_time` INT NOT NULL DEFAULT '0' COMMENT '轮盘总次数',
  `roulette_used_time` INT NOT NULL DEFAULT '0' COMMENT '已抽奖次数',
  `wallet` VARCHAR(64) BINARY COMMENT '会员当前钱包',
  `status` INT NOT NULL DEFAULT '1' COMMENT '用户状态',
  `is_login` INT NOT NULL DEFAULT '0' COMMENT '是否已登录过：默认0-未登录过 1-已登录过',
  `create_user` VARCHAR(64) BINARY NOT NULL COMMENT '创建人',
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `update_user` VARCHAR(64) BINARY NOT NULL COMMENT '修改人',
  `update_date` DATETIME NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY(login_name)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- 奖品表
CREATE TABLE `t_prize` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `prize_name` VARCHAR(64) BINARY NOT NULL COMMENT '奖品名称',
  `prize_pic` VARCHAR(64) BINARY NOT NULL COMMENT '奖品图片路径',
  `amount` INT NOT NULL DEFAULT '0' COMMENT '奖品价值：默认0',
  `max_num` INT NOT NULL DEFAULT '0' COMMENT '奖品最大数量',
  `used_num` INT NOT NULL DEFAULT '0' COMMENT '奖品已用数量',
  `rate` DECIMAL(18,6) NOT NULL DEFAULT '0' COMMENT '基础中奖概率，0.12表示百分之12',
  `vip_rate` VARCHAR(256) COMMENT 'VIP中奖概率，如果有设置，优先基础中奖概率，格式为:vip0_1_0.12;vip1_0_null;vip2_0_null;vip3_0_null;vip4_0_null;vip5_0_null;',
  `status` INT NOT NULL DEFAULT '1' COMMENT '状态：1有效 0失效',
  `create_user` VARCHAR(64) BINARY NOT NULL COMMENT '创建人',
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `update_user` VARCHAR(64) BINARY NOT NULL COMMENT '修改人',
  `update_date` DATETIME NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY(prize_name)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- 会员抽奖表
CREATE TABLE `t_cust_prize` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bill_no` VARCHAR(64) BINARY NOT NULL COMMENT '抽奖编号',
  `prize_id` INT COMMENT '奖品id',
  `prize_name` VARCHAR(64) BINARY COMMENT '奖品名称',
  `login_name` VARCHAR(64) BINARY NOT NULL COMMENT '会员登录名',
  `request_date` DATETIME COMMENT '首次被请求的时间',
  `wallet` VARCHAR(64) BINARY COMMENT '收款钱包',
  `create_user` VARCHAR(64) BINARY NOT NULL COMMENT '创建人',
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `update_user` VARCHAR(64) BINARY NOT NULL COMMENT '修改人',
  `update_date` DATETIME NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY(bill_no)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- 字典表
CREATE TABLE `t_dict` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dict_type` VARCHAR(64) BINARY NOT NULL COMMENT '字典类型',
  `dict_code` VARCHAR(64) BINARY NOT NULL COMMENT '字典编码',
  `dict_name` VARCHAR(64) BINARY NOT NULL COMMENT '字典名称',
  `dict_val` VARCHAR(64) BINARY COMMENT '字典值-字符串',
  `dict_val_big` VARCHAR(512) BINARY COMMENT '字典值-大字符串',
  `parent_dict_code` VARCHAR(64) BINARY COMMENT '上级字典编码',
  `is_default` INT NOT NULL DEFAULT 0 COMMENT '是否默认值：1-是 0-否',
  `status` INT NOT NULL DEFAULT '1' COMMENT '状态：1有效 0失效',
  `sort_num` INT NOT NULL DEFAULT 1 COMMENT '序号,查询后一般按此序号排序',
  `create_user` VARCHAR(64) BINARY NOT NULL COMMENT '创建人',
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `update_user` VARCHAR(64) BINARY NOT NULL COMMENT '修改人',
  `update_date` DATETIME NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY(dict_type, dict_code)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- 比赛表
CREATE TABLE `t_contest` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `contest_type` VARCHAR(64) BINARY NOT NULL COMMENT '比赛类型',
  `contest_name` VARCHAR(64) BINARY NOT NULL COMMENT '比赛名称',
  `contest_date` DATETIME NOT NULL COMMENT '比赛开始时间',
  `team_first` VARCHAR(64) BINARY NOT NULL COMMENT '甲队',
  `team_second` VARCHAR(64) BINARY NOT NULL COMMENT '乙队',
  `status` INT NOT NULL DEFAULT '1' COMMENT '状态：1有效 0失效',
  `sort_num` INT NOT NULL DEFAULT 1 COMMENT '序号,查询后一般按此序号排序',
  `create_user` VARCHAR(64) BINARY NOT NULL COMMENT '创建人',
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `update_user` VARCHAR(64) BINARY NOT NULL COMMENT '修改人',
  `update_date` DATETIME NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
-- 日志表
CREATE TABLE `t_sys_log` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `login_name` VARCHAR(64) BINARY COMMENT '被操作信息所属人账号',
  `sys_type` INT COMMENT '系统类型：1-office 2-api',
  `log_type` INT NOT NULL COMMENT '日志类型:1-清除密码, 2-添加次数',
  `before_val` VARCHAR(128) BINARY COMMENT '前值',
  `change_val` VARCHAR(128) BINARY COMMENT '变化值',
  `after_val` VARCHAR(128) BINARY COMMENT '后值',
  `log_remark` VARCHAR(128) BINARY COMMENT '备注',
  `create_user` VARCHAR(64) BINARY NOT NULL COMMENT '创建人',
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `update_user` VARCHAR(64) BINARY NOT NULL COMMENT '修改人',
  `update_date` DATETIME NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 初始化数据- 密码 123qwe
INSERT INTO `t_sys_user` (`login_name`, `login_pass`, `status`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('admin','ed2e19985ad3a06c810efa1e53e70832','1','barplus','2022-08-20 14:00:40','barplus','2022-08-20 14:00:42');
-- 初始化字典
-- vip字典
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('VIP','VIP0','VIP0','VIP0',NULL,NULL,'0','1','1','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('VIP','VIP1','VIP1','VIP1',NULL,NULL,'0','1','2','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('VIP','VIP2','VIP2','VIP2',NULL,NULL,'0','1','3','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('VIP','VIP3','VIP3','VIP3',NULL,NULL,'0','1','4','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('VIP','VIP4','VIP4','VIP4',NULL,NULL,'0','1','5','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('VIP','VIP5','VIP5','VIP5',NULL,NULL,'0','1','6','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('VIP','VIP6','VIP6','VIP6',NULL,NULL,'0','1','7','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('VIP','VIP7','VIP7','VIP7',NULL,NULL,'0','1','8','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('VIP','VIP8','VIP8','VIP8',NULL,NULL,'0','1','9','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('VIP','VIP9','VIP9','VIP9',NULL,NULL,'0','1','10','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('VIP','VIP10','VIP10','VIP10',NULL,NULL,'0','1','11','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');
-- 钱包字典
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('WALLET','亚博体育','亚博体育','亚博体育',NULL,NULL,'0','1','1','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('WALLET','亚博真人','亚博真人','亚博真人',NULL,NULL,'0','1','2','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');
INSERT INTO `t_dict` (`dict_type`, `dict_code`, `dict_name`, `dict_val`, `dict_val_big`, `parent_dict_code`, `is_default`, `status`, `sort_num`, `create_user`, `create_date`, `update_user`, `update_date`)
VALUES('WALLET','中心钱包','中心钱包','中心钱包',NULL,NULL,'1','1','3','barplus','2022-08-20 14:28:14','barplus','2022-08-20 14:28:16');