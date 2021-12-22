package com.study;

import com.study.mbean.ConfigMBean;
import com.study.mbean.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.StringJoiner;

@RestController
@SpringBootApplication
@Import({Config.class})
public class Main {
    @Autowired
    Config config;

    @Autowired
    ConfigMBean blackListMBean;

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        SpringApplication.run(Main.class);

//        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
//        ObjectName name = new ObjectName("com.my:type=Hello");
//        Hello mbean = new Hello();
//        mbs.registerMBean(mbean, name);
    }

    @RequestMapping("/")
    public String postExecute(){
        return config.getMaxCount();
    }

    @RequestMapping("/hello")
    public String hello(){
        return System.getProperty("word");
    }

    @RequestMapping("/black")
    public String get(){
        return blackListMBean.getIP();
    }
}
