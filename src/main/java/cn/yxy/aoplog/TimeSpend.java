package cn.yxy.aoplog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeSpend {
	
	private static Logger logger=LogManager.getLogger(TimeSpend.class);
	private long startTime;
	
	//@Pointcut("execution(* com.test.spring.aop.pointcutexp..JoinPointObjP2.*(..))")  
    //@Pointcut("within(com.test.spring.aop.pointcutexp..*)")  
    //@Pointcut("this(com.test.spring.aop.pointcutexp.Intf)")  
    //@Pointcut("target(com.test.spring.aop.pointcutexp.Intf)")  
    //@Pointcut("@within(org.springframework.transaction.annotation.Transactional)")  
    //@Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")  
    //@Pointcut("args(String)")
	@Pointcut("@annotation(cn.yxy.aoplog.RequiredTS)")
//	@Pointcut("@annotation(org.springframework.stereotype.Repository)")
	private void loggingOperation(){}
	
	@Before("loggingOperation()")
	public void start(){
		startTime=System.currentTimeMillis();
	}
	
	@After("loggingOperation()")
	public void after(JoinPoint joinPoint){
		long timeSpend=System.currentTimeMillis()-startTime;
		logger.info("The mothed ["+joinPoint.getSignature().getName()+"] used "+timeSpend+"ms");
	}
}
