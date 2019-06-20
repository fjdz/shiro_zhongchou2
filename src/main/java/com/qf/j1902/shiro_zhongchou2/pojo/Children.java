package com.qf.j1902.shiro_zhongchou2.pojo;

import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * Auto-generated: 2019-06-13 16:50:47
 * 二级菜单树对象
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class Children {

    private String id;

    private String pid;

    private Integer seqno = 1;

    private String name;//菜单名字

    private String url = "";//地址

    private String icon = "";//图标

    private boolean open = true;//默认是否打开

    private boolean checked;//是否选中

    private List<Children> children;//菜单 没有为空

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Children children = (Children) o;
        return Objects.equals(name, children.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}