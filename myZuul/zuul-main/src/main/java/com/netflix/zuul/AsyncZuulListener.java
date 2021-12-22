package com.netflix.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AsyncZuulListener implements AsyncListener {
    private static final Logger  LOGGER = LoggerFactory.getLogger(AsyncZuulListener.class);

    @Override
    public void onComplete(AsyncEvent event) throws IOException {
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        LOGGER.error("Access {} timeout in AsyncServlet.", ((HttpServletRequest)event.getAsyncContext().getRequest()).getRequestURL());
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        LOGGER.error("Error while access {} in AsyncServlet.", ((HttpServletRequest)event.getAsyncContext().getRequest()).getRequestURL());
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
    }
}