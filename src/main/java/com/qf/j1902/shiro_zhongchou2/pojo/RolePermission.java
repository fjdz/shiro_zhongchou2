package com.qf.j1902.shiro_zhongchou2.pojo;

import lombok.Data;

@Data
public class RolePermission {
    private Integer rpId;

    private Integer roleId;

    private Integer permissionId;

    private boolean checked;
}