package com.chang.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chang.springsecurity.entity.User;

import java.util.List;

/**
 * @Author: cactus
 * @CreateDate: 2020/5/5 11:32
 * @Description:
 */
public interface UserMapper extends BaseMapper<User> {
    List<User> findAll();

    User findByUsername(String username);

    int save(User user);
}
