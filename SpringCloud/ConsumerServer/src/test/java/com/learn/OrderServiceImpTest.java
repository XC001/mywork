package com.learn;

import com.learn.controller.BookController;
import com.learn.pojo.Book;
import com.learn.pojo.TOrder;
import com.learn.service.OrderServiceImp;
import com.learn.service.UserService;
import io.reactivex.netty.protocol.udp.server.UdpServer;
import org.assertj.core.matcher.AssertionMatcher;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImpTest {

    @Mock
    OrderServiceImp orderServiceImp;

    @Mock
    UserService userService;

    @Mock
    BookController bookController;

    @Test
    public void select(){
        when(bookController.book(any(Book.class))).thenReturn(Response.ok(new Book("1","java","xxx","abc@qq.com")).build());
        Book book = (Book)bookController.book(new Book()).getEntity();
        Assert.assertEquals("1",book.getId());
        Assert.assertThat(book.getId(), equalTo("1"));
    }
}
