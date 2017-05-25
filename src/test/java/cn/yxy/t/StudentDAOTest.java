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
	private StudentDAO studentDAO;

	@Test
	public void getByIdTest() throws Exception{
		
		Student stu = studentDAO.getById(4);
		System.out.println(stu);
	}
	
	@Test
	public void deleteByIdTest() {
		boolean t=studentDAO.deleteById(40);
		System.out.println(t);
	}
	
	@Test
	public void updateTest() {
		Student stu=RandomStuUtil.getRandomStu();
		stu.setId(30);
		boolean t=studentDAO.update(stu);
		System.out.println(t);
	}
	
	@Test
	public void insertTest() {
		Student stu=RandomStuUtil.getRandomStu();
		long t=studentDAO.insert(stu);
		System.out.println(stu.getId());
		System.out.println(t);
	}
	
	@Test
	public void getByNameTest() throws Exception{
		Student stu = studentDAO.getByName("赵文博");
		System.out.println(stu);
	}

}
