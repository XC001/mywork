package com.learn.transformer;

import com.learn.pojo.User;
import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class MyHttpMessageConverter extends AbstractHttpMessageConverter<User> {

    public MyHttpMessageConverter() {
        super(MediaType.ALL);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return User.class==clazz;
    }

    @Override
    protected User readInternal(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String[] info = IOUtils.toString(inputMessage.getBody()).split(":");
        User user = new User();
        user.setId(Integer.parseInt(info[0]));
        user.setName(info[1]);
        user.setSex(info[2]);
        user.setAddr(info[3]);
        return user;
    }

    @Override
    protected void writeInternal(User user, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        outputMessage.getBody().write(user.toString().getBytes(StandardCharsets.UTF_8));
    }
}
