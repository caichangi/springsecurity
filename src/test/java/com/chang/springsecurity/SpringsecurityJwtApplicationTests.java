package com.chang.springsecurity;

import com.chang.springsecurity.entity.User;
import com.chang.springsecurity.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: cactus
 * @CreateDate: 2020/5/5 11:52
 * @Description:
 */
@SpringBootTest
class SpringsecurityJwtApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

}
