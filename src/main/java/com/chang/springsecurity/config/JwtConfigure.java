package com.chang.springsecurity.config;

/**
 * @Author: cactus
 * @CreateDate: 2020/5/5 11:52
 * @Description:
 */
public class JwtConfigure {

    public static final long EXPIRATION_TIME = 432_000_000;     // 5天(以毫秒ms计)
    public static final String SECRET = "SystemSecret";      // JWT密码
    public static final String TOKEN_PREFIX = "Bearer";         // Token前缀
    public static final String HEADER_STRING = "Authorization"; // 存放Token的Header Key
}
