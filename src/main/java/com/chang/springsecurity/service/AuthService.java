package com.chang.springsecurity.service;

import com.chang.springsecurity.entity.User;
import com.chang.springsecurity.entity.response.Result;

/**
 * @Author: cactus
 * @CreateDate: 2020/5/5 11:52
 * @Description:
 */
public interface AuthService {
    Result register(User userToAdd );
    String login( String username, String password );
}