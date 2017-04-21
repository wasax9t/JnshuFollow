package cn.spring.dao;

public interface StudentDAO {
	/*
	 * 添加一个学生数据
	 * @return插入的自动生成ID
	 */
	public long addStu(String[] args);
	
	/*
	 * 根据ID删除学生数据
	 */
	public boolean delStuByID(long aID);
	
	/*
	 * 根据ID查询学生数据
	 * @return TODO String应改为student对象
	 */
	public String findStuByID(long aID);
	
	/*
	 * 根据ID更新学生数据
	 */
	public boolean updateStuByID(String[] args);
}
