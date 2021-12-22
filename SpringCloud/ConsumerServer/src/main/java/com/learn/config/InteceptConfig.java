package com.learn.config;

import com.learn.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InteceptConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor())
        .addPathPatterns("/**");
        String s="    <tu creationdate=\"20211208T131054Z\" creationid=\"MCNHD6OFDIOUDGX\\Administrator\" changedate=\"20211208T131057Z\" changeid=\"MCNHD6OFDIOUDGX\\Administrator\" lastusagedate=\"20211208T131321Z\" usagecount=\"1\">\n" +
                "      <prop type=\"x-LastUsedBy\">MCNHD6OFDIOUDGX\\Administrator</prop>\n" +
                "      <prop type=\"x-Context\">0, 0</prop>\n" +
                "      <prop type=\"x-Origin\">TM</prop>\n" +
                "      <prop type=\"x-ConfirmationLevel\">Translated</prop>\n" +
                "      <tuv xml:lang=\"zh-CN\">\n" +
                "        <seg>"

                +"</seg>\n" +
                "      </tuv>\n" +
                "      <tuv xml:lang=\"en-US\">\n" +
                "        <seg>"

                +"</seg>\n" +
                "      </tuv>\n" +
                "    </tu>";
    }
}
