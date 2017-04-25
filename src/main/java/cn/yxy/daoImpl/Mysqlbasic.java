package cn.yxy.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mysqlbasic {
    private static final String DBURL = "jdbc:mysql://localhost:3306/db_jnshu_follow";
	private static final String DBUSER = "root";
	private static final String DBPASS = "admin";
	
	Connection conn=null;

	public boolean initConn(){
		boolean tf=false;
    	//加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("fuck it!!Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //连接数据库
        try{
        	conn=DriverManager.getConnection(DBURL
        			+"?useUnicode=true&characterEncoding=utf-8&useSSL=false",DBUSER,DBPASS);
        	System.out.println("Connection geted");
        	tf=true;
        } catch(Exception e){
        	e.printStackTrace();
        }
        
		return tf;
    }
	public boolean closeConn(){
		boolean tf=false;
		//断开连接
        try{
        	conn.close();
        	System.out.println("conn closed");
        	tf=true;
        } catch(Exception e){
        	e.printStackTrace();
        }
		return tf;
	}
}