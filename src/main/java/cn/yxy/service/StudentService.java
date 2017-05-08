package cn.yxy.service;

import cn.yxy.domain.Student;

public interface StudentService {

	/*
	 * 注册学生用户
	 * @return 学生id
	 */
	long login(Student stu);
	
	/*
	 * 删除学生数据
	 */
	boolean delete(long id);
	
	/*
	 * 更新学生数据
	 */
	boolean update(Student stu);
	
	/*
	 * 查找学生数据
	 * @param 学生id
	 */
	Student search(long id);
	
	/*
	 * @param 学生姓名
	 */
	Student search(String name);
	
}
