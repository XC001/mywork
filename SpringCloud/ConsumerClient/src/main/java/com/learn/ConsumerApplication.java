package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ConsumerApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
//        SpringApplication.run(ConsumerApplication.class);
        System.out.println(System.getProperty("local.server.port"));
    }
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
