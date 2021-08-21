package com.learn.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("feignConfig")
public class FeignConfig {
    @Bean
    Logger.Level getLogLevel(){
        //记录所有请求和响应的明细
        return Logger.Level.FULL;
    }
}
