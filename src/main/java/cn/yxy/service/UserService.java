package cn.yxy.service;

import cn.yxy.domain.User;

public interface UserService {

	boolean deleteByPrimaryKey(long id);
	 
    long insert(User user);
    
    long insertSelective(User user);
 
    User selectByPrimaryKey(long id);
 
    boolean updateByPrimaryKey(User user);
    
    boolean updateByPrimaryKeySelective(User user);
     
    /**
     * 根据用户名查用户详情
     * */
    User selectByName(String name);
     
    
}
