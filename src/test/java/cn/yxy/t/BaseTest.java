package cn.yxy.t;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml", "classpath:spring/spring-sdk.xml" })
public abstract class BaseTest {

}
