package cn.yxy.aoplog;

import java.util.concurrent.TimeoutException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.yxy.domain.User;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

@Aspect
@Component
public class MemcachedSeviceAOP {

    @Autowired
    private MemcachedClient memcachedClient;

    @Pointcut("execution(* cn.yxy.service.impl.UserServiceImpl.*(..))")
    public void UserCachedPointcut() {
    }

    @Around("UserCachedPointcut()&&args(id)")
    public User findByIdCache(ProceedingJoinPoint call, long id) {
        User user = null;
        String key = "findById_" + id;
        try {
            user = memcachedClient.get(key);
        } catch (TimeoutException | InterruptedException | MemcachedException e1) {
            e1.printStackTrace();
        }
        if (user == null) {
            try {
                user = (User) call.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            boolean stored;
            try {
                stored = memcachedClient.set(key, 0, user);
//				System.out.println("when user==null "+user+"stored?"+stored);
            } catch (TimeoutException | InterruptedException | MemcachedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return user;
    }
}
