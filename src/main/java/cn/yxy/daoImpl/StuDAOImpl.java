package cn.yxy.daoImpl;

import java.sql.ResultSet;
import java.sql.Statement;

import cn.yxy.dao.StudentDAO;
import cn.yxy.data_object.StudentDO;
import cn.yxy.dbc_pool.MySQLUnit;

public class StuDAOImpl implements StudentDAO {

	public long insert(StudentDO stu) {
		long temp=0;
		MySQLUnit mb=new MySQLUnit();
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

	public boolean deleteByID(long ID) {
		boolean TorF=false;
		MySQLUnit mb=new MySQLUnit();
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

	public StudentDO getByID(long ID) {
		MySQLUnit mb=new MySQLUnit();
		StudentDO stu=null;
		if(mb.initConn()){
			Statement stmt=null;
			ResultSet rset=null;
			
			
	        String findString="SELECT name,more_info,periods,city,field FROM student WHERE ID="+ID;
	        try{
	        	stmt=mb.conn.createStatement();
	            rset=stmt.executeQuery(findString);
	            stu = new StudentDO();
	    		while(rset.next()){
	    			//TODO stu
	    		}
	            System.out.println("stmt executed,rset");
	            stmt.close();
	            
	        } catch(Exception e){
	        	e.printStackTrace();
	        }
		}
		mb.closeConn();
		return stu;
	}

	public boolean updateByID(long ID,StudentDO stu) {
		boolean TorF=false;
		MySQLUnit mb=new MySQLUnit();
		String h2update=null;
		
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
