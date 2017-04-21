package cn.spring.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MysqlDemo {
    private static final String DBURL = "jdbc:mysql://localhost:3306/db_jnshu_follow";
	private static final String DBUSER = "root";
	private static final String DBPASS = "admin";

	public static void main(String[] args) throws Exception {
    	//加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("fuck it!!Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //连接数据库
        Connection conn=null;
        try{
        	conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        	System.out.println("Connection geted");
        } catch(Exception e){
        	e.printStackTrace();
        }
        //执行语句
        Statement stmt=null;
        String insertString="INSERT INTO student"
        		+ " VALUES (DEFAULT, '20170417', NULL, '名字', NULL, 19, '北京', 'UI', DEFAULT);";
        try{
        	stmt=conn.createStatement();
            stmt.executeUpdate(insertString);
            System.out.println("stmt executed");
            stmt.close();
        } catch(Exception e){
        	e.printStackTrace();
        }
        //断开连接
        try{
        	conn.close();
        	System.out.println("conn closed");
        } catch(Exception e){
        	e.printStackTrace();
        }
        
    }
}