package cn.liuyiyou.yishop.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-dal.xml",
		"classpath:spring-biz.xml",
		"classpath:spring-service.xml" })
public class AbstractServiceTest extends
		AbstractTransactionalJUnit4SpringContextTests {

}
