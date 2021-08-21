package com.learn.intercept;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.util.JwtUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map result = new HashMap();
        String authentication = request.getHeader("Authentication");
        if (StringUtils.isEmpty(authentication) || !authentication.startsWith("Bearer ")){
            result.put("msg", "Token校验异常");
        }else{
            try {
                JwtUtil.validateJwtToken(authentication.replace("Bearer ", ""));
                return true;
            }catch (SignatureVerificationException e){
                result.put("msg", "签名异常");
            }catch (TokenExpiredException e){
                result.put("msg", "Token已过期");
            }catch (AlgorithmMismatchException e){
                result.put("msg", "加密算法不匹配");
            }catch (Exception e){
                result.put("msg", "Token校验异常");
            }

        }
        response.setContentType("application/json;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult = objectMapper.writeValueAsString(result);
        response.getWriter().println(jsonResult);
        return false;
    }
}
