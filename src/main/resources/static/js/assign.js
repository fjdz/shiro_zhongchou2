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

    var relaid = $("#Characterid").val();
    var url = "/ajax/getUserMenuTree/" + relaid;
    var setting = {
        check: {
            enable: true
        },
        view: {
            selectedMulti: false,
            addDiyDom: function (treeId, treeNode) {
                var icoObj = $("#" + treeNode.tId + "_ico");
                if (treeNode.icon) {
                    icoObj.removeClass("button ico_docu ico_open").addClass("fa fa-fw " + treeNode.icon).css("background", "");
                }
            },
        },
        async: {
            enable: true,
            url: url
        },
        callback: {
            onClick: function (event, treeId, json) {
            }
        }
    };
    $.fn.zTree.init($("#treeDemo"), setting);
});


$("#but1").click(function () {
    var id = $("#Characterid").val();
    var zTree = $.fn.zTree.getZTreeObj("treeDemo");
    var checkNodes = zTree.getCheckedNodes(true);
    //搜集选中的标准问法信息
    var checkInfo = [];
    for (var i = 0; i < checkNodes.length; i++) {
        var node = checkNodes[i];
        checkInfo.push(node.id);
    }

    $.ajax({
        type: "POST",
        url: "/ajax/setMenuTree",
        data: {
            "checkInfo": checkInfo,
            "id": id
        },
        success: function () {
            alert("分配成功");
            window.location.replace("/admin/role");
        },
        error: function (data) {
            alert("分配失败:" + data);
        }
    });
});