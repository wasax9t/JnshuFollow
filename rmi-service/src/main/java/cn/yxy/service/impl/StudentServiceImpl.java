package cn.yxy.service.impl;

import cn.yxy.dao.StudentMapper;
import cn.yxy.domain.Student;
import cn.yxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("StudentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper stuDAO;

    public long insert(Student stu) {

        stuDAO.insert(stu);
        return stu.getid();
    }

    public boolean delete(long id) {
        boolean tf = stuDAO.deleteByid(id);
        return tf;
    }

    public boolean update(Student stu) {
        boolean tf = stuDAO.update(stu);
        return tf;
    }

    public Student get(long id) {
        Student stu = stuDAO.getByid(id);
        return stu;
    }

    public Student get(String name) {
        Student stu = stuDAO.getByName(name);
        return stu;
    }

}
