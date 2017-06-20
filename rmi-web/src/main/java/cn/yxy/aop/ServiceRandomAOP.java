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
public class ServiceRandomAOP {

    @Pointcut("execution(* cn.yxy.controller.StudentController.*(..))")
    public void studentControllerPointcut() {
    }


}
