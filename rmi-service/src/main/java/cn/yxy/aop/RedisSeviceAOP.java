package cn.yxy.aop;

import cn.yxy.domain.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.PostConstruct;

//@Aspect
//@Component
public class RedisSeviceAOP {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;
    private ValueOperations<String, User> redisOps;

    @PostConstruct
    public void init() {
        redisOps = redisTemplate.opsForValue();
    }

    @Pointcut("execution(* cn.yxy.service.impl.UserServiceImpl.*(..))")
    public void UserCachedPointcut() {
    }

    @Around("UserCachedPointcut()&&args(id)")
    public User findByIdCache(ProceedingJoinPoint call, long id) {
        User user = null;
        String key = "findById_" + id;
        user = redisOps.get(key);
        if (user == null) {
            try {
                user = (User) call.proceed();
            } catch (Throwable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            boolean success = redisOps.setIfAbsent(key, user);
//			System.out.println(success);
        }
        return user;
    }
}
