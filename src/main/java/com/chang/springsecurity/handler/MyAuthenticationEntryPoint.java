package com.chang.springsecurity.handler;

import cn.hutool.json.JSONUtil;
import com.chang.springsecurity.entity.response.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: cactus
 * @CreateDate: 2020/5/5 12:49
 * @Description: authenticationEntryPoint 用来解决匿名用户访问无权限资源时的异常
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.getWriter().write(JSONUtil.toJsonStr(new Result(403,null,"小朋友,你的token不存在!")));
    }
}
