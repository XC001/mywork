package com.learn;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.annotation.EnableJms;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.learn.mapper")
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableJms
public class ConsumerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServerApplication.class, args);

//        standardEncryptor();
    }

//    @Bean("jasyptStringEncryptor")
//    public static StringEncryptor pooledStandardEncryptor(){
//        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
//        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
//        config.setPassword("admin");
//        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
//        config.setKeyObtentionIterations("1000");
//        config.setPoolSize("1");
//        config.setProviderName("SunJCE");
//        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
//        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
//        config.setStringOutputType("base64");
//        encryptor.setConfig(config);
//
//        return encryptor;
//    }

    @Bean("jasyptStringEncryptor")
    public StringEncryptor standardEncryptor(){
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setProvider(new BouncyCastleProvider());
        encryptor.setAlgorithm("PBEWITHSHA-256AND256BITAES-CBC-BC");
        encryptor.setPassword("the");

        return encryptor;
    }
}
