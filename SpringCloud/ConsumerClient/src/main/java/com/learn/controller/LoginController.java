package com.learn.controller;

import com.learn.util.JwtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = (String)request.getParameter("username");
        String password = (String)request.getParameter("password");
        if(StringUtils.isEmpty(username)
                || !"admin".equals(username)
                || StringUtils.isEmpty(password)
                || !"password".equals(password)){
//            request.setAttribute("alert", "error");
//            request.getRequestDispatcher("login").forward(request, response);
            response.sendRedirect("login?error");
        }else{
            String token = JwtUtil.getJwtToken(username);
            response.addHeader("Authentication", String.format("Bearer %s", token));
            response.sendRedirect("index.html");
        }
    }
}
