package com.study.mbean;

import org.springframework.beans.factory.annotation.Autowired;
import sun.management.Util;

import javax.management.ObjectName;

public class Hello implements HelloMXBean{

    public void changeMWord(String word) {
        System.setProperty("word", word);
    }

}
