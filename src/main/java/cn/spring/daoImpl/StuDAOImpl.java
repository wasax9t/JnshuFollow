package cn.spring.daoImpl;

import java.sql.ResultSet;
import java.sql.Statement;

import cn.spring.dao.StudentDAO;

public class StuDAOImpl implements StudentDAO {

	public long addStu(String[] args) {
		long temp=0;
		Mysqlbasic mb=new Mysqlbasic();
		if(mb.initConn()){
			Statement stmt=null;
	        String insertString="INSERT INTO student"
	        		+ " VALUES (DEFAULT, '20170417', NULL, '名字', NULL, 19, '北京', 'UI', DEFAULT);";
	        try{
	        	stmt=mb.conn.createStatement();
	            stmt.executeUpdate(insertString);
	            System.out.println("stmt executed");
	            stmt.close();
	            temp=1;
	        } catch(Exception e){
	        	e.printStackTrace();
	        }
		}
		mb.closeConn();
		// TODO ID???
		return temp;
	}

	public boolean delStuByID(long ID) {
		boolean TorF=false;
		Mysqlbasic mb=new Mysqlbasic();
		if(mb.initConn()){
			Statement stmt=null;
	        String deleteString="DELETE FROM student WHERE "+"ID="+ID;
	        try{
	        	stmt=mb.conn.createStatement();
	            stmt.executeUpdate(deleteString);
	            System.out.println("stmt executed");
	            stmt.close();
	            TorF=true;
	        } catch(Exception e){
	        	e.printStackTrace();
	        }
		}
		mb.closeConn();
		return TorF;
	}

	public String[] findStuByID(long ID) {
		Mysqlbasic mb=new Mysqlbasic();
		String[] strs = null;
		if(mb.initConn()){
			Statement stmt=null;
			ResultSet rset=null;
			
	        String findString="SELECT name,more_info,periods,city,field FROM student WHERE ID="+ID;
	        try{
	        	stmt=mb.conn.createStatement();
	            rset=stmt.executeQuery(findString);
	            strs=new String[5];
	    		while(rset.next()){
	    			strs[0]=rset.getString("name");
		    		strs[1]=rset.getString("more_info");
		    		strs[2]=rset.getString("periods");
		    		strs[3]=rset.getString("city");
		    		strs[4]=rset.getString("field");
	    		}
	            System.out.println("stmt executed,rset");
	            stmt.close();
	            
	        } catch(Exception e){
	        	e.printStackTrace();
	        }
		}
		mb.closeConn();
		System.out.println(strs[0]);
		return strs;
	}

	public boolean updateStuByID(long ID,String[] args) {
		boolean TorF=false;
		Mysqlbasic mb=new Mysqlbasic();
		String h2update=null;
		// TODO use regular translate args to name,QQ...
		if(true){
			h2update="name="+"'被修改啦~'";
		}
		if(mb.initConn()){
			Statement stmt=null;
	        String updateString="UPDATE student SET "+h2update
	        		+ " WHERE "+"ID="+ID;
	        try{
	        	stmt=mb.conn.createStatement();
	            stmt.executeUpdate(updateString);
	            System.out.println("stmt executed");
	            stmt.close();
	            TorF=true;
	        } catch(Exception e){
	        	e.printStackTrace();
	        }
		}
		mb.closeConn();
		return TorF;
	}

}
