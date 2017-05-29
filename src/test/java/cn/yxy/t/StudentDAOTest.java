package cn.yxy.t;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.yxy.dao.StudentMapper;
import cn.yxy.domain.Student;
import cn.yxy.util.RandomStuUtil;

/**
 * 数据库连接池使用测试
 * 
 */

public class StudentDAOTest extends BaseTest {
	@Autowired
	private StudentMapper studentMapper;

	@Test
	public void getByidTest() throws Exception{
		
		Student stu = studentMapper.getByid(4);
		System.out.println(stu);
	}
	
	@Test
	public void deleteByidTest() {
		boolean t=studentMapper.deleteByid(40);
		System.out.println(t);
	}
	
	@Test
	public void updateTest() {
		Student stu=RandomStuUtil.getRandomStu();
		stu.setid(30);
		boolean t=studentMapper.update(stu);
		System.out.println(t);
	}
	
	@Test
	public void insertTest() {
		Student stu=RandomStuUtil.getRandomStu();
		long t=studentMapper.insert(stu);
		System.out.println(stu.getid());
		System.out.println(t);
	}
	
	@Test
	public void getByNameTest() throws Exception{
		Student stu = studentMapper.getByName("赵文博");
		System.out.println(stu);
	}

}
