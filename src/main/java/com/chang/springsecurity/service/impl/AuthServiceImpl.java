package com.chang.springsecurity.service.impl;

import com.chang.springsecurity.entity.User;
import com.chang.springsecurity.entity.response.Result;
import com.chang.springsecurity.mapper.UserMapper;
import com.chang.springsecurity.service.AuthService;
import com.chang.springsecurity.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: cactus
 * @CreateDate: 2020/5/5 11:52
 * @Description:
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserMapper userMapper;

    // 登录
    @Override
    public String login( String username, String password ) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken( username, password );
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername( username );
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    // 注册
    @Override
    public Result register(User userToAdd ) {
        final String username = userToAdd.getUsername();
        if( userMapper.findByUsername(username)!=null ) {
            return new Result(400,null,"账号已存在!");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword( encoder.encode(rawPassword) );
        int i = userMapper.save(userToAdd);
        if (i>=0){
            User user = userMapper.findByUsername(userToAdd.getUsername());
            user.setPassword("******");
            return new Result(200,user,"注册成功!");
        }
        else {
            return new Result(406,null,"发生未知错误，注册失败!");
        }
    }
}