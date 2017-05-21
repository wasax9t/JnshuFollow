package cn.yxy.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import cn.yxy.aoplog.RequiredTS;
import cn.yxy.domain.Student;


public interface StudentDAO {
	/*
	 * 添加一个学生数据
	 * @return mybatis自动return的是1
	 */
	@Insert("INSERT INTO student(create_at,name, periods, city, course) VALUES(#{createAt}, #{name}, #{periods}, #{city}, #{course})")
	long insert(Student stu);
	
	/*
	 * 根据id删除学生数据
	 */
	boolean deleteById(long id);
	
	/*
	 * 根据id查询学生数据
	 * @return Student对象
	 */
	Student getById(long id);
	
	/*
	 * 更新学生数据
	 */
	boolean update(Student stu);

	/*
	 * 根据name查询学生数据
	 * @return Student对象
	 */
	@Select("SELECT id,create_at,name,sno,periods,city,course FROM student "
			+ "WHERE name = #{name}")
	Student getByName(String name);
}
