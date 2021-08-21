package com.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket getDocket(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.apiInfo(getApiInfo()).enable(true).select().build();

        return docket;
    }

    public ApiInfo getApiInfo(){
        return new ApiInfo("Api Documentation", "Api Documentation", "1.0", "urn:tos", new Contact("", "", ""), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }
}
