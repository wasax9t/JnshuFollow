package cn.yxy.t;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.yxy.dao.StudentDAO;
import cn.yxy.domain.Student;
import cn.yxy.util.RandomStuUtil;

/**
 * 数据库连接池使用测试
 * 
 */

public class StudentDAOTest extends BaseTest {
	@Autowired
	private StudentDAO sos;

	@Test
	public void getByIdTest() throws Exception{
		
		Student stu = sos.getById(9);
		System.out.println(stu);
	}
	
	@Test
	public void deleteByIdTest() {
		boolean t=sos.deleteById(40);
		System.out.println(t);
	}
	
	@Test
	public void updateTest() {
		Student stu=new Student();
		stu.setId(30);
		boolean t=sos.update(stu);
		System.out.println(t);
	}
	
	@Test
	public void insertTest() {
		Student stu=new Student();
		System.out.println(stu.getId());
		long t=sos.insert(stu);
		System.out.println(stu.getId());
		System.out.println(t);
	}
	
	@Test
	public void getByNameTest() throws Exception{
		Student stu = sos.getByName("赵文博");
		System.out.println(stu);
	}

}
