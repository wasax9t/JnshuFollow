
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yxy.domain.Student;
import cn.yxy.mappers.StudentMapper;
import cn.yxy.util.RandomStuUtil;

/**
 * 数据库连接池使用测试
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class StudentMapperTest {
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void insertTest() {
    	Student stu=RandomStuUtil.getRandomStu();
        long id = studentMapper.insertStu(stu);
        System.out.println(id);
    }
}