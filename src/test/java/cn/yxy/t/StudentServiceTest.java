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
	public void insertTest() {
		Student stu=RandomStuUtil.getRandomStu();
		long id=sos.insert(stu);
		System.out.println(id);
	}
	
	@Test
	public void getTest(){
		Student stu=sos.get(4);
		System.out.println(stu);
	}
	
	@Test
	public void deleteTest(){
		boolean tf=sos.delete(21);
		System.out.println(tf);
	}
	
	@Test
	public void updateTest(){
		Student stu=RandomStuUtil.getRandomStu();
		stu.setId(22);
		boolean tf=sos.update(stu);
		System.out.println(tf);
	}
}
