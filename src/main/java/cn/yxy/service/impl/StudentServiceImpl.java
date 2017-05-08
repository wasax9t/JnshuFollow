package cn.yxy.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yxy.dao.StudentDAO;
import cn.yxy.domain.Student;
import cn.yxy.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private Logger logger=LogManager.getLogger(this.getClass());
	
	@Autowired
	private StudentDAO stuDAO;

	@Transactional
	public long login(Student stu) {
		
		stuDAO.insert(stu);
		logger.info(stu);
		return stu.getId();
	}

	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Student stu) {
		// TODO Auto-generated method stub
		return false;
	}

	public Student search(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
