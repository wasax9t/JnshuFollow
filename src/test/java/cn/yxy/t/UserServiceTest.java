package cn.yxy.t;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import cn.yxy.domain.User;
import cn.yxy.service.UserService;
import net.rubyeye.xmemcached.MemcachedClient;

public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;
    @Autowired
    private MemcachedClient memcachedClient;
    @Autowired
    private RedisTemplate<String, User> redisTemplate;
    private ValueOperations<String, User> operations;


    public void insertTest() {
        User user = new User();
        user.setId(2);
        user.setName("测试数据");
        user.setPassword("password");
        long id = userService.insert(user);
        System.out.println(id);
    }


    public void selectByNameTest() {
        String name = "test";
        User result = userService.selectByName(name);
        System.out.println(result.getPassword());
    }

    @Test
    public void selectByNameLikeTest() {
        List<User> result = userService.selectByNameLike("t");
        System.out.println(result);
    }


    public void selectByIdTest() {
        User result = userService.selectByPrimaryKey(3);
        System.out.println(result.getPassword());
//		String value=(String) memcachedClient.get("test");
//		System.out.println(value);
    }
}
