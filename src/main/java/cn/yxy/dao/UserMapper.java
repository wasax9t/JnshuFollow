package cn.yxy.dao;

import java.util.List;

import cn.yxy.domain.User;

public interface UserMapper {
	boolean deleteByPrimaryKey(Long id);

	long insert(User record);

	long insertSelective(User record);

	User selectByPrimaryKey(Long id);

	boolean updateByPrimaryKeySelective(User record);

	boolean updateByPrimaryKey(User record);

	/**
	 * 根据用户信息查用户详情（登录）
	 */
	User selectByUser(User user);

	/**
	 * 根据用户名查用户详情
	 */
	User selectByName(String name);

	List<User> selectByNameLike(String str);
}