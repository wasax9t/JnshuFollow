package cn.yxy.dao;

import java.sql.Connection;

import cn.yxy.domain.Student;

public interface StudentDAO {
	/*
	 * 添加一个学生数据
	 * @return插入的自动生成ID
	 */
	long insert(Student stu);
	
	/*
	 * 根据ID删除学生数据
	 */
	boolean deleteByID(long aID);
	
	/*
	 * 根据ID查询学生数据
	 * @return 暂为name,more_info,periods,city,field的一个字符串数组
	 */
	Student getByID(long aID);
	
	/*
	 * 根据ID更新学生数据，将使用正则判断需更新的信息（未实现）
	 */
	boolean updateByID(long ID,Student stu);
}
