package cn.yxy.service;

import cn.yxy.domain.AutoLogins;

public interface AutoLoginsService {
    int deleteByPrimaryKey(Integer id);
 
    int insert(AutoLogins aLogins);
    
    int insertSelective(AutoLogins aLongs);
 
    AutoLogins selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKeySelective(AutoLogins aLogin);
 
    int updateByPrimaryKey(AutoLogins aLogins);
    /**
     * 通过用户名和UUID值查询自动登录记录
     * 
     * @param username
     *            用户名
     * @param series
     *            UUID值
     *
     */
    AutoLogins selectByUsernameAndSeries(String username,String series);
    /**
     * 通过用户名查询自动登录记录
     * 
     * @param username
     *            用户名
     */
    AutoLogins selectByUsername(String username);  
}
