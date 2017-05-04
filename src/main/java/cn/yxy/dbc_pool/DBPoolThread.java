package cn.yxy.dbc_pool;



import java.sql.Connection;

import cn.yxy.daoImpl.StuDAOImpl;
import cn.yxy.domain.Student;
import cn.yxy.util.RandomStuUtil;

public class DBPoolThread extends Thread{
	private DBPool dp;
	
	public DBPoolThread(String name,DBPool dp) {
		super(name);
		this.dp=dp;
	}
	
	public void run(){
		Connection c=dp.getConn();
//		System.out.println(this.getName()+" got");
		
		Student stu=RandomStuUtil.getRandomStu();
		StuDAOImpl stuDAO=new StuDAOImpl(c);
		stuDAO.insert(stu);
//		try {
//			Thread.sleep(1000);//假设需要这些时间来执行SQL语句
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		dp.givebackConn(c);
//		System.out.println(this.getName()+" giveback over");
		
	}
}
