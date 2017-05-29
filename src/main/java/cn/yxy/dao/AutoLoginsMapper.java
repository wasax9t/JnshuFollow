package cn.yxy.dao;

import org.apache.ibatis.annotations.Param;

import cn.yxy.domain.AutoLogins;

public interface AutoLoginsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AutoLogins record);

    int insertSelective(AutoLogins record);

    AutoLogins selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutoLogins record);

    int updateByPrimaryKey(AutoLogins record);
    
    /**
     * 通过用户名和UUID值查询自动登录记录
     * 
     * @param username
     *            用户名
     * @param series
     *            UUID值
     */
    AutoLogins selectByUsernameAndSeries(@Param("username") String username, @Param("series") String series);
 
    /**
     * 通过用户名查询自动登录记录
     * 
     * @param username
     *            用户名
     */
    AutoLogins selectByUsername(@Param("username") String username);
}