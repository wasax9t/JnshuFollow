package cn.yxy.aoplog;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented         //注解将被包含在javadoc中
@Retention(RUNTIME) //注解的保留策略,运行时可以通过反射获取到
@Target(METHOD)     //注解的作用目标
public @interface RequiredTS {

}
