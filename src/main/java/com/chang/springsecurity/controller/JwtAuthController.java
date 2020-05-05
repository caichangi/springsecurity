package com.chang.springsecurity.controller;

import com.chang.springsecurity.entity.User;
import com.chang.springsecurity.entity.response.Result;
import com.chang.springsecurity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: cactus
 * @CreateDate: 2020/5/5 11:52
 * @Description:
 */
@RestController
public class JwtAuthController {
    @Autowired
    private AuthService authService;

    // 登录
    @RequestMapping(value = "/authentication/login", method = RequestMethod.POST)
    public Result createToken( String username,String password ) throws AuthenticationException {
        String token = authService.login(username, password);// 登录成功会返回JWT Token给用户
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        return new Result(200,tokenMap,"小朋友，登陆成功!");
    }

    // 注册
    @RequestMapping(value = "/authentication/register", method = RequestMethod.POST)
    public Result register(@RequestBody User addedUser ) throws AuthenticationException {
        return authService.register(addedUser);
    }
}