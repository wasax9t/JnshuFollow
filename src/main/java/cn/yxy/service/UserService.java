package cn.yxy.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
     
    /**
     * 登录
     * 
     * @param user
     *            登录的用户信息
     * @param rememberme
     *            是否记住登录
     * @param response
     *            HttpServletResponse
     * @return 根据传递的用户信息在数据库中查询到的用户详情
     */
    User login(User user, boolean rememberme, HttpServletResponse response);
     
    /**
     * 退出登录
     * */
    void logout(HttpServletRequest request,HttpServletResponse response);
}
