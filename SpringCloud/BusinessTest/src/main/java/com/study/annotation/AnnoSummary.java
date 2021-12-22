package com.study.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
@CrossOrigin
public class AnnoSummary {
    @Value("${person}")
    private String person;


    @ResponseBody
    public void get(@RequestBody String msg){
        Thread thread = new Thread(() -> {
            //...;
        });
        thread.run();
    }

}
