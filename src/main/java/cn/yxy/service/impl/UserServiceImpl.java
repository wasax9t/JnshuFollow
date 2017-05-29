package cn.yxy.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yxy.dao.UserMapper;
import cn.yxy.domain.AutoLogins;
import cn.yxy.domain.User;
import cn.yxy.service.AutoLoginsService;
import cn.yxy.service.UserService;
import cn.yxy.util.CookieConstantTable;
import cn.yxy.util.CookieUtil;
import cn.yxy.util.EncryptionUtil;
import cn.yxy.util.StringUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AutoLoginsService autoLoginsService;
	
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

	@Override
	public User login(User user, boolean rememberMe, HttpServletResponse response) {
		User result = new User();
        // 如果用户名和密码不为空，执行登录
        if (StringUtil.isNotBlank(user.getUserName()) && StringUtil.isNotBlank(user.getPassword())) {
            result = userMapper.selectByUser(user);
            // 如果rememberme为true，则保存cookie值，下次自动登录
            if (result != null && rememberMe == true) {
                // 有效期
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MONTH, 1); // 一个月
                Date validTime = calendar.getTime();
                // 精确到分的时间字符串
                String timeString = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"
                        + calendar.get(Calendar.DAY_OF_MONTH) + "-" + calendar.get(Calendar.HOUR_OF_DAY) + "-"
                        + calendar.get(Calendar.MINUTE);
 
                // sha256加密用户信息
                String userInfoBySha256 = EncryptionUtil
                        .sha256Hex(result.getUserName() + "_" + result.getPassword() + "_" + timeString + "_" + CookieConstantTable.SALT);
                // UUID值
                String uuidString = UUID.randomUUID().toString();
                // Cookie值
                String cookieValue = EncryptionUtil.base64Encode(result.getUserName() + ":" + uuidString);
 
                // 在数据库中保存自动登录记录（如果已有该用户的记录则更新记录）
                AutoLogins aLogin = autoLoginsService.selectByUsername(result.getUserName());
                if (aLogin == null) {
                    aLogin = new AutoLogins();
                    aLogin.setUsername(result.getUserName());
                    aLogin.setSeries(uuidString);
                    aLogin.setToken(userInfoBySha256);
                    aLogin.setValidtime(validTime);
                    autoLoginsService.insertSelective(aLogin);
                }else{
                    aLogin.setSeries(uuidString);
                    aLogin.setToken(userInfoBySha256);
                    aLogin.setValidtime(validTime);
                    autoLoginsService.updateByPrimaryKeySelective(aLogin);
                }
 
                // 保存cookie
                CookieUtil.addCookie(response, CookieConstantTable.REMEMBER_ME, cookieValue, null);
            }
 
        }
        return result;
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		//从session中获取用户详情
        User user = (User) request.getSession().getAttribute("user");
        //删除数据库中的自动登录记录
        AutoLogins aLogins = autoLoginsService.selectByUsername(user.getUserName());
        if(aLogins != null)
        	autoLoginsService.deleteByPrimaryKey(aLogins.getid());
        //清除session和用于自动登录的cookie
        request.getSession().removeAttribute("user");
        CookieUtil.delCookie(request, response, CookieConstantTable.REMEMBER_ME);

	}

}
