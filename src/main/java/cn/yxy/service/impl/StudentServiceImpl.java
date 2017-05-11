package cn.yxy.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yxy.dao.StudentDAO;
import cn.yxy.domain.Student;
import cn.yxy.service.StudentService;

@Service
@Qualifier("StudentService")
public class StudentServiceImpl implements StudentService{
	
	private Logger logger=LogManager.getLogger(this.getClass());
	
	@Autowired
	private StudentDAO stuDAO;

	@Transactional
	public long login(Student stu) {
		
		stuDAO.insert(stu);
		logger.info(stu+"login down");
		return stu.getId();
	}

	@Transactional
	public boolean delete(long id) {
		boolean tf=stuDAO.deleteById(id);
		logger.info(id+"deleted:"+tf);
		return tf;
	}

	@Transactional
	public boolean update(Student stu) {
		boolean tf=stuDAO.update(stu);
		
		return tf;
	}

	@Transactional
	public Student get(long id) {
		Student stu=stuDAO.getById(id);
		
		return stu;
	}

	@Transactional
	public Student get(String name) {
		Student stu=stuDAO.getByName(name);
		
		return stu;
	}

}
