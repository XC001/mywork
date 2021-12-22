package com.study.mbean;

import jdk.Exported;

import java.lang.management.PlatformManagedObject;

@Exported
public interface HelloMXBean {
    void changeMWord(String word);
}
