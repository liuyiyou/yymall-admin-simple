
-- 分类品牌表
CREATE TABLE `category_brand` (
  `cata_id` int(11) NOT NULL COMMENT '外键，base_catalog.cata_id',
  `brand_id` int(11) NOT NULL COMMENT '外键，关联base_brand.brand_id',
  `brand_weight` int(11) DEFAULT NULL COMMENT '品牌权重',
  `create_date` date DEFAULT NULL COMMENT '关联创建时间',
  `last_update` date DEFAULT NULL COMMENT '关联最后修改时间',
  PRIMARY KEY (`cata_id`,`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类品牌表';

