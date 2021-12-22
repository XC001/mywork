package com.learn.controller;

import com.learn.pojo.Book;
import com.learn.validation.ValidationBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response;
import java.util.Set;

@RestController
public class BookController {
    @Autowired
    Validator validator;

    @RequestMapping("/book")
    public Response book(@Valid @RequestBody Book book){
        Set<ConstraintViolation<Book>> violation = validator.validate(book, ValidationBook.class);

        if(!violation.isEmpty()){
            ConstraintViolation<Book> constraintViolation = violation.stream().findFirst().get();
            return Response.ok(constraintViolation.getMessage()).build();
        }

        return Response.ok(book).build();
    }
}
