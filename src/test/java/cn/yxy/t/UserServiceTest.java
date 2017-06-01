package cn.yxy.t;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.yxy.domain.User;
import cn.yxy.service.UserService;

public class UserServiceTest extends BaseTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void insertTest() {
		User user=new User();
		user.setId(2);
		user.setName("测试数据");
		user.setPassword("password");
		long id=userService.insert(user);
		System.out.println(id);
	}
	
	@Test
	public void selectByNameTest(){
		String name="test";
		User result=userService.selectByName(name);
		System.out.println(result.getPassword());
		//我看看是报错还是
	}
}
