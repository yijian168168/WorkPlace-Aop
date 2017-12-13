package com.aop.aspectj;

import com.aop.dao.Person;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015/10/27 0027.
 */
@Aspect
@Component
public class ExecutionAspectj {

//    @Before("execution(public String com.aop.controller.*.*(..))")
    /*public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        try {
            Object [] args = joinPoint.getArgs();
            BeanUtils.copyProperties(args[0],args[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(methodName + ":" );
    }*/

    /*@AfterThrowing(pointcut="execution(public String com.aop.controller.PersonController.personService3(..))",throwing="e")
    public String aferThrowing(JoinPoint joinPoint , Exception e){
        String methodName = joinPoint.getSignature().getName();
        Person person = (Person) joinPoint.getArgs()[0];
        System.out.println("+++:" + person);
        System.out.println("An exception "+e +", has been throwing in "+ methodName + "()");
        return "ok";
    }*/


    @Around(value = "personService3()")
    public Object aferThrowing(ProceedingJoinPoint joinPoint) {
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

    @Pointcut(value = "execution(* com.aop.controller.PersonController.personService3(..))")
    public void personService3(){}


}
