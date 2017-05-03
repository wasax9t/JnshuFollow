package cn.yxy.dbc_pool;



import java.sql.Connection;

import cn.yxy.daoImpl.StuDAOImpl;
import cn.yxy.data_object.StudentDO;

public class DBPoolThread extends Thread{
	private DBPool dp;
	
	public DBPoolThread(String name,DBPool dp) {
		super(name);
		this.dp=dp;
	}
	
	public void run(){
		Connection c=dp.getConn();
		System.out.println(this.getName()+" got");
		
		StudentDO stuDO=new StudentDO();
		StuDAOImpl stuDAO=new StuDAOImpl();
		stuDAO.insert(stuDO, c);
//		try {
//			Thread.sleep(1000);//假设需要这些时间来执行SQL语句
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		dp.givebackConn(c);
		System.out.println(this.getName()+" giveback over");
		
	}
}
