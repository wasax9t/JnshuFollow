package cn.yxy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yxy.dao.AutoLoginsMapper;
import cn.yxy.domain.AutoLogins;
import cn.yxy.service.AutoLoginsService;

@Service
public class AutoLoginsServiceImpl implements AutoLoginsService {

	@Autowired
	private AutoLoginsMapper autoLoginsMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return autoLoginsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(AutoLogins aLogins) {
		return autoLoginsMapper.insert(aLogins);
	}
	
	@Override
    public int insertSelective(AutoLogins aLogins) {
        return autoLoginsMapper.insertSelective(aLogins);
    }

	@Override
	public AutoLogins selectByPrimaryKey(Integer id) {
		return autoLoginsMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(AutoLogins aLogins) {
		return autoLoginsMapper.updateByPrimaryKey(aLogins);
	}
	
	@Override
    public int updateByPrimaryKeySelective(AutoLogins aLogins) {
        return autoLoginsMapper.updateByPrimaryKeySelective(aLogins);
    }

	@Override
	public AutoLogins selectByUsernameAndSeries(String username, String series) {
		return autoLoginsMapper.selectByUsernameAndSeries(username, series);
	}

	@Override
	public AutoLogins selectByUsername(String username) {
		return autoLoginsMapper.selectByUsername(username);
	}

}
