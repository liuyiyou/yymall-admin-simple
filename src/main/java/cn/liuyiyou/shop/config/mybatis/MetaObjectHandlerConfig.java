package cn.liuyiyou.shop.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * @author ybd
 */
public class MetaObjectHandlerConfig implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		LocalDateTime fieldVal = LocalDateTime.now();
		setFieldValByName("createTime", fieldVal, metaObject);
		setFieldValByName("updateTime", fieldVal, metaObject);
		setFieldValByName("deleted", false, metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		LocalDateTime fieldVal = LocalDateTime.now();
		setFieldValByName("updateTime", fieldVal, metaObject);
	}
}
