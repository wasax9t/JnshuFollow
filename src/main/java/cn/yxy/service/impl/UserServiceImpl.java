package cn.yxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yxy.dao.UserMapper;
import cn.yxy.domain.User;
import cn.yxy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public boolean deleteByPrimaryKey(long id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public long insert(User user) {
		return userMapper.insert(user);
	}
	
	@Override
    public long insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

	@Override
	public User selectByPrimaryKey(long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean updateByPrimaryKey(User user) {
		return userMapper.updateByPrimaryKey(user);
	}
	
	@Override
    public boolean updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

	@Override
	public User selectByName(String name) {
		return userMapper.selectByName(name);
	}

}
