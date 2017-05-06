package cn.yxy.mappers;

import cn.yxy.domain.Student;

public interface StudentMapper {

	public long insertStu(Student stu);
	
	public boolean deleteStu(long id);
	
	public Student getStuById(long id);
	
	public boolean updateStu(Student Stu);
}
