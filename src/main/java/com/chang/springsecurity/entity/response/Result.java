package com.chang.springsecurity.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: cactus
 * @CreateDate: 2020/5/5 11:53
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int code;
    private Object data;
    private String msg;

}
