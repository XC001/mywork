package com.study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

public class Config {
    @Value("${maxCount}")
    private String maxCount;

    public String getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(String maxCount) {
        this.maxCount = maxCount;
    }
}
