package com.learn.ques01;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = new MyClassLoader().findClass("Hello");
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("hello", null);
        method.invoke(obj, null);
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            File file = new File("E:\\learning\\学习\\极客时间学习资料\\作业相关\\Hello.xlass");

            FileInputStream fis = new FileInputStream(file);
            byte[] realClassBytes = new byte[fis.available()];
            fis.read(realClassBytes);
            for (int i = 0; i < realClassBytes.length; i++) {
                realClassBytes[i] = (byte)(0xFF^realClassBytes[i]);
            }
            return defineClass(name, realClassBytes, 0, realClassBytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
