package com.qf.j1902.shiro_zhongchou2.vo;

import com.qf.j1902.shiro_zhongchou2.pojo.RolePermission;
import lombok.Data;

import java.util.List;

/**
 * @author ：邓一凡
 * @date ：Created in 2019/6/17 23:10
 * @description ： 前端ajax提交权限角色关系集合
 */
@Data
public class RolePermissionVo {
    List<Integer> rolePermissionList;
}
