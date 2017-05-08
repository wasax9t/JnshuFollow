//package cn.yxy.daoImpl;
//
//
//import org.apache.ibatis.session.SqlSession;
//
//import cn.yxy.dao.StudentDAO;
//import cn.yxy.domain.Student;
//import cn.yxy.mappers.StudentMapper;
//import cn.yxy.util.MyBatisUtil;
//
//public class StudentDAOImpl implements StudentDAO{
//	
//	public long insertStu(Student stu){
//		SqlSession sqlSession=MyBatisUtil.getSqlSessionFactory().openSession();
//		try {
//			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
//			studentMapper.insertStu(stu);
//			sqlSession.commit();
//		} finally {
//			sqlSession.close();
//		}
//		return stu.getId();
//	}
//
//	public boolean deleteByID(long aID) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public Student getStuByID(long aID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public boolean updateStu(Student stu) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//}
