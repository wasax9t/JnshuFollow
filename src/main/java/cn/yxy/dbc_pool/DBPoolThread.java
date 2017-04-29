package cn.yxy.dbc_pool;

import java.sql.Connection;

public class DBPoolThread extends Thread{
	private DBPool dp;
	
	public DBPoolThread(String name,DBPool dp) {
		super(name);
		this.dp=dp;
	}
	
	public void run(){
		Connection c=dp.getConn();
		System.out.println(this.getName()+" got");
		try {
			Thread.sleep(1000);//假设需要这些时间来执行SQL语句
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dp.givebackConn(c);
		System.out.println(this.getName()+" giveback over");
	}
}
