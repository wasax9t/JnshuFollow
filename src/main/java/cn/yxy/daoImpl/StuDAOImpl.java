//package cn.yxy.daoImpl;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import cn.yxy.dao.StudentDAO;
//import cn.yxy.dbc_pool.DBPool;
//import cn.yxy.dbc_pool.MySQLUnit;
//import cn.yxy.domain.Student;
//
//public class StuDAOImpl implements StudentDAO {
//	
////	private static final Logger logger=LogManager.getLogger(StuDAOImpl.class);
//
//	private Connection conn;
//	
//	public StuDAOImpl(Connection conn){
//		this.conn=conn;
//	}
//
//	public long insertStu(Student stu) {
//		long id = 0;
//		Statement stmt=null;
//		String insertS="INSERT INTO student"
//				+ " VALUES(DEFAULT,"+stu.getCreateAt() + 
//				",NULL,""+stu.getName()+"",NULL,"+stu.getPeriods()+
//				",""+stu.getCity()+"",""+stu.getCourse()+
//				"",DEFAULT)";
////		System.out.println(insertS);
////		logger.info(insertS);
//		try {
//			stmt = conn.createStatement();
//			stmt.executeUpdate(insertS);
//			stmt.close();
//		} catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		return id;
//	}
//
//	public boolean deleteStu(long ID) {
//		boolean TorF = false;
//		Connection conn = null;
//		try {
//			conn = MySQLUnit.getConn();
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		Statement stmt = null;
//		String deleteString = "DELETE FROM student WHERE " + "ID=" + ID;
//		try {
//			stmt = conn.createStatement();
//			stmt.executeUpdate(deleteString);
//			System.out.println("stmt executed");
//			stmt.close();
//			TorF = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return TorF;
//	}
//
//	public Student getStuByID(long ID) {
//		Student stu = null;
//		Connection conn = null;
//		try {
//			conn = MySQLUnit.getConn();
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		Statement stmt = null;
//		ResultSet rset = null;
//
//		String findString = "SELECT name,more_info,periods,city,field FROM student WHERE ID=" + ID;
//		try {
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(findString);
//			stu = new Student();
//			while (rset.next()) {
//				// TODO stu
//			}
//			System.out.println("stmt executed,rset");
//			stmt.close();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return stu;
//	}
//
//	public boolean updateStu(Student stu) {
//		boolean TorF = false;
//		String h2update = null;
//
//		if (true) {
//			h2update = "name=" + ""被修改啦~"";
//		}
//		Connection conn = null;
//		try {
//			conn = MySQLUnit.getConn();
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//		Statement stmt = null;
//		String updateString = "UPDATE student SET " + h2update + " WHERE " + "ID=" + id;
//		try {
//			stmt = conn.createStatement();
//			stmt.executeUpdate(updateString);
//			System.out.println("stmt executed");
//			stmt.close();
//			TorF = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return TorF;
//	}
//
//}
