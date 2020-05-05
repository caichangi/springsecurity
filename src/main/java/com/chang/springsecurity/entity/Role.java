package com.chang.springsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: cactus
 * @CreateDate: 2020/5/5 11:21
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Long id;
    private String roleName;
    // 角色描述
    private String description;
}
