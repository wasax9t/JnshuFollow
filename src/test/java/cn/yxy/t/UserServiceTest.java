package cn.yxy.t;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.yxy.domain.User;
import cn.yxy.service.UserService;

public class UserServiceTest extends BaseTest {

	@Autowired
	private UserService userService;
	
//	@Test
//	public void insertTest() {
//		User user=new User();
//		user.setid(2);
//		user.setUserName("测试数据");
//		user.setPassword("password");
//		long id=userService.insert(user);
//		System.out.println(id);
//	}
	
	@Test
	public void loginTest(){
		User user=new User();
		user.setid(3);
		user.setUserName("测试数据");
		user.setPassword("password");
		User result=new User();
//		HttpServletResponse response=;
//		result=userService.login(user, true, response);
		System.out.println(result);
	}
}
