package cn.yxy.t;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.yxy.domain.Student;
import cn.yxy.service.StudentService;
import cn.yxy.util.RandomStuUtil;

/**
 * 数据库连接池使用测试
 * 
 */

public class StudentServiceTest extends BaseTest {
	
	@Autowired
	private StudentService sos;

	@Test
	public void test1() {
		Student stu=RandomStuUtil.getRandomStu();
		long id=sos.login(stu);
		System.out.println(id);
	}
		
}
