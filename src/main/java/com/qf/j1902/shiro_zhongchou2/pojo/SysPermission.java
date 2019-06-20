package com.qf.j1902.shiro_zhongchou2.pojo;

import lombok.Data;

import java.util.Objects;

@Data
public class SysPermission {
    private Integer permissionId;

    private String perName;

    private String menuName;

    private String menuType;

    private String menuUrl;

    private String menuCode;

    private String parentCode;

    private String perDesc;

    private Integer ifVilid;

    private String iconClass;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysPermission that = (SysPermission) o;
        return Objects.equals(perName, that.perName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(perName);
    }
}