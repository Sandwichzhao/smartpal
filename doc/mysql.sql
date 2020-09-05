-- 用户表
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '昵称',
  `account` varchar(64) NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `pic_url` varchar(64) NOT NULL COMMENT '图片地址',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- 采购订单
CREATE TABLE `input_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `serial_number` varchar(64) DEFAULT NULL COMMENT '订单流水号',
  `user_id` varchar(64) NOT NULL DEFAULT '' COMMENT '采购人id',
  `address` varchar(64) NOT NULL COMMENT '采购地址',
  `number` varchar(64) NOT NULL COMMENT '采购数量',
  `price` varchar(64) NOT NULL COMMENT '价格',
  `statement` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` tinyint(4) DEFAULT 1 COMMENT '1有效,0失效',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='采购订单';



-- 采购付款
CREATE TABLE `input_pay` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `serial_number` varchar(64) DEFAULT NULL COMMENT '订单流水号',
  `user_id` varchar(64) NOT NULL DEFAULT '' COMMENT '付款人id',
  `need_pay` varchar(64) NOT NULL COMMENT '应付账款',
  `already_pay` varchar(64) NOT NULL COMMENT '已付账款',
  `remain_pay` varchar(64) NOT NULL COMMENT '欠款',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='采购付款';

-- 付款历史
CREATE TABLE `input_pay_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `serial_number` varchar(64) DEFAULT NULL COMMENT '订单流水号',
  `user_id` varchar(64) NOT NULL DEFAULT '' COMMENT '付款人id',
  `pay_money` varchar(64) NOT NULL COMMENT '账款金额',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='付款历史';


-- ################################# 价格监控 #################################
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `store_id` varchar(64) DEFAULT NULL COMMENT '店铺pk',
  `snapshot_time` varchar(1024) NOT NULL COMMENT '抓取时间',
  `name` varchar(64) DEFAULT NULL COMMENT '商品名称',
  `pirce` varchar(64) NOT NULL DEFAULT '' COMMENT '商品价格',
  `url` varchar(1024) NOT NULL COMMENT '商品图片url',
  `statement` varchar(1024) NOT NULL COMMENT '说明',
  `uuid` varchar(1024) DEFAULT NULL COMMENT '唯一id',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='商品信息';


CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) DEFAULT NULL COMMENT '店铺名称',
  `note` varchar(1024) NOT NULL DEFAULT '' COMMENT '备注',
  `url` varchar(1024) NOT NULL COMMENT '爬虫抓取URL',
  `status` varchar(1024) NOT NULL COMMENT '状态',
  `created_at` datetime NOT NULL COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='店铺信息';



