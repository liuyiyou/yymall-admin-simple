package cn.liuyiyou.yishop.mapper;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.liuyiyou.yishop.entity.LoginInfo;

public class LoginInfoMapperTest extends AbstractMapperTest {
	
	@Autowired
	private LoginInfoMapper loginInfoMapper;
	
	@Test
	public void insertTest(){
		LoginInfo t =new LoginInfo();
		t.setUserId(1);
		t.setUserName("中文");
		t.setLoginType("M");
		t.setPassword("123456");
		t.setCreateTime(new Date());
		loginInfoMapper.insert(t);
		
		System.out.println(t.getId());
		System.out.println(t.getLastUpdateTime());
	}
	
	@Test
	public void queryByUserIdAndLoginTypeTest(){
		LoginInfo info = loginInfoMapper.queryByUserIdAndLoginType(5,"M");
		System.out.println(info.getLastLoginTime());
	}

}
