package com.aop.aspectj;

import com.aop.annotations.DataSource;
import com.aop.annotations.LogPrint;
import com.aop.dao.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015/10/27 0027.
 */
@Aspect
@Component
public class AnnotationAspectj {

    /**
     * 通过注解做切面，并获取注解内的值
     * */
    @Before(value = "@annotation(logPrint)")
    public void logPrint(JoinPoint joinPoint, LogPrint logPrint) {
        String methodName = joinPoint.getSignature().getName();
        try {
            System.out.println("获取切面方法 " + methodName + "上注解的值 ： " + logPrint.value());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(methodName + ":");
    }

    /**
     * 通过注解做切面，并获取注解内的值
     * */
    @Before(value = "@annotation(dataSource)")
    public void dataSource(JoinPoint joinPoint, DataSource dataSource) {
        String methodName = joinPoint.getSignature().getName();
        try {
            System.out.println("获取切面方法 " + methodName + "上注解的值 ： " + dataSource.value());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(methodName + ":");
    }


    @Around(value = "LogPrint()")
    public Object around(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Person person = (Person) joinPoint.getArgs()[0];
        try {
            Object ret = joinPoint.getTarget();
            System.out.println(ret);
            Object result = joinPoint.proceed();
            System.out.println(result);
        } catch (Throwable throwable) {
//            throwable.printStackTrace();
        }
        System.out.println("+++:" + person);
        System.out.println("An exception " + "" + ", has been throwing in " + methodName + "()");
        return "ok";
    }

    @Pointcut(value = "@annotation(com.aop.annotations.LogPrint)")
    public void LogPrint() {
    }


}
