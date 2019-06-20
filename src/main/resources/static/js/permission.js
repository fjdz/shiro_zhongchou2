$(function () {
    $(".list-group-item").click(function () {
        if ($(this).find("ul")) {
            $(this).toggleClass("tree-closed");
            if ($(this).hasClass("tree-closed")) {
                $("ul", this).hide("fast");
            } else {
                $("ul", this).show("fast");
            }
        }
    });
    var setting = {
        view: {
            selectedMulti: false,
            addDiyDom: function (treeId, treeNode) {
                var icoObj = $("#" + treeNode.tId + "_ico"); // tId = permissionTree_1, $("#permissionTree_1_ico")
                if (treeNode.icon) {
                    icoObj.removeClass("button ico_docu ico_open").addClass("fa fa-fw " + treeNode.icon).css("background", "");
                }
            },
            addHoverDom: function (treeId, treeNode) {
                var aObj = $("#" + treeNode.tId + "_a"); // tId = permissionTree_1, ==> $("#permissionTree_1_a")
                // aObj.attr("href", "javascript:;");
                if (treeNode.editNameFlag || $("#btnGroup" + treeNode.tId).length > 0) return;
                var s = '<span id="btnGroup' + treeNode.tId + '">';
                if (treeNode.level === 0) {
                    s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" href="#" >&nbsp;&nbsp;<i class="fa fa-fw fa-plus rbg "></i></a>';
                } else if (treeNode.level === 1) {
                    s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;"  href="#" title="修改权限信息">&nbsp;&nbsp;<i class="fa fa-fw fa-edit rbg "></i></a>';
                    if (treeNode.children.length === 0) {
                        s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" href="#" >&nbsp;&nbsp;<i class="fa fa-fw fa-times rbg "></i></a>';
                    }
                    s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" href="#" >&nbsp;&nbsp;<i class="fa fa-fw fa-plus rbg "></i></a>';
                } else if (treeNode.level === 2) {
                    s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;"  href="#" title="修改权限信息">&nbsp;&nbsp;<i class="fa fa-fw fa-edit rbg "></i></a>';
                    s += '<a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" href="#">&nbsp;&nbsp;<i class="fa fa-fw fa-times rbg "></i></a>';
                }

                s += '</span>';
                aObj.after(s);
            },
            removeHoverDom: function (treeId, treeNode) {
                $("#btnGroup" + treeNode.tId).remove();
            }
        },
        async: {
            enable: true,
            url: "/ajax/getMenuTree"
        },
        callback: {
            onClick: function (event, treeId, json) {

            }
        }
    };
    $.fn.zTree.init($("#treeDemo"), setting); //异步访问数据 请求方式是POST

    /*  var d = [{
          "id": 1,
          "pid": 0,
          "seqno": 0,
          "name": "系统权限菜单",
          "url": null,
          "icon": "fa fa-sitemap",
          "open": true,
          "checked": false,
          "children": [{
              "id": 2,
              "pid": 1,
              "seqno": 0,
              "name": "控制面板",
              "url": "dashboard.htm",
              "icon": "fa fa-desktop",
              "open": true,
              "checked": false,
              "children": []
          }, {
              "id": 6,
              "pid": 1,
              "seqno": 1,
              "name": "消息管理",
              "url": "message/index.htm",
              "icon": "fa fa-weixin",
              "open": true,
              "checked": false,
              "children": []
          }, {
              "id": 7,
              "pid": 1,
              "seqno": 1,
              "name": "权限管理",
              "url": "",
              "icon": "fa fa-cogs",
              "open": true,
              "checked": false,
              "children": [{
                  "id": 8,
                  "pid": 7,
                  "seqno": 1,
                  "name": "用户管理",
                  "url": "user/index.htm",
                  "icon": "fa fa-user",
                  "open": true,
                  "checked": false,
                  "children": []
              }, {
                  "id": 9,
                  "pid": 7,
                  "seqno": 1,
                  "name": "角色管理",
                  "url": "role/index.htm",
                  "icon": "fa fa-graduation-cap",
                  "open": true,
                  "checked": false,
                  "children": []
              }, {
                  "id": 10,
                  "pid": 7,
                  "seqno": 1,
                  "name": "许可管理",
                  "url": "permission/index.htm",
                  "icon": "fa fa-check-square-o",
                  "open": true,
                  "checked": false,
                  "children": []
              }]
          }, {
              "id": 11,
              "pid": 1,
              "seqno": 1,
              "name": "资质管理",
              "url": "",
              "icon": "fa fa-certificate",
              "open": true,
              "checked": false,
              "children": [{
                  "id": 12,
                  "pid": 11,
                  "seqno": 1,
                  "name": "分类管理",
                  "url": "cert/type.htm",
                  "icon": "fa fa-th-list",
                  "open": true,
                  "checked": false,
                  "children": []
              }, {
                  "id": 13,
                  "pid": 11,
                  "seqno": 1,
                  "name": "资质管理",
                  "url": "cert/index.htm",
                  "icon": "fa fa-certificate",
                  "open": true,
                  "checked": false,
                  "children": []
              }]
          }, {
              "id": 15,
              "pid": 1,
              "seqno": 1,
              "name": "流程管理",
              "url": "process/index.htm",
              "icon": "fa fa-random",
              "open": true,
              "checked": false,
              "children": []
          }, {
              "id": 16,
              "pid": 1,
              "seqno": 1,
              "name": "审核管理",
              "url": "",
              "icon": "fa fa-check-square",
              "open": true,
              "checked": false,
              "children": [{
                  "id": 17,
                  "pid": 16,
                  "seqno": 1,
                  "name": "实名认证人工审核",
                  "url": "process/cert.htm",
                  "icon": "fa fa-check-circle-o",
                  "open": true,
                  "checked": false,
                  "children": []
              }]
          }]
      }];
      $.fn.zTree.init($("#treeDemo"), setting, d);*/
});