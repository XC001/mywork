package com.learn.test;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyTest {


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(new MyIntercept());
        Person person = (Person)enhancer.create();
        person.say();
    }
}
class Person {
    public void say(){
        System.out.println("hello");
    }
}

class MyIntercept implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin");
        methodProxy.invokeSuper(o, objects);
        System.out.println("end");
        return null;
    }
}