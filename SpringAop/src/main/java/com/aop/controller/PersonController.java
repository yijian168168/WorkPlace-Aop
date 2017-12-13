package com.aop.controller;

import com.aop.dao.Person;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2015/10/27 0027.
 */
@Service
public class PersonController {

    public String personService1(Person person,Map<String,String> personConfig){

        System.out.println("personService1:" + person);
        return "";
    }

    public String personService2(Person person,Map<String,String> personConfig){

        System.out.println("personService2:" + person);
        return "";
    }

    public String personService3(Person person,Map<String,String> personConfig) throws Exception {

        System.out.println("personService3:" + person);
        throw new Exception("我是测试");
//        return "";
    }
}
