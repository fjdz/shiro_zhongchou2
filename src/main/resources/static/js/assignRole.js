var userSysRole = $("#userSysRoles");//获取已分配列表select对象
var unassignedRole = $("#unassignedRoles");//获取未分配列表
var userid = $("#userid").val();


$(".glyphicon-chevron-left").click(function () {
    var valueop = userSysRole.val();//已分配列表 的值
    var checkText = userSysRole.find("option:selected").text(); //获取Select选择的Text
    if (valueop != null) {
        $.ajax({
            type: "POST",
            url: "/ajax/delRole",
            data: {
                "userid": userid,
                "roleId": valueop
            },
            success: function (msg) {
                unassignedRole.append("<option id=" + checkText + " value='" + valueop + "'>" + checkText + "</option>");//添加到未分配列表
                $("#userSysRoles option:selected").remove(); //删除已分配列表Select被选中的项
            },
            error: function (data) {
                alert("分配失败:" + data);
            }
        });
    }
});


$(".glyphicon-chevron-right").click(function () {
    var valueop = unassignedRole.val();//未分配列表值
    var checkText = unassignedRole.find("option:selected").text(); //获取Select选择的Text
    if (valueop != null) {
        $.ajax({
            type: "POST",
            url: "/ajax/addRole",
            data: {
                "userid": userid,
                "roleId": valueop
            },
            success: function (msg) {
                userSysRole.append("<option id=" + checkText + " value='" + valueop + "'>" + checkText + "</option>");//添加到已分配列表
                $("#unassignedRoles option:selected").remove(); //删除未分配列表Select被选中的项
            },
            error: function (data) {
                alert("分配失败:" + data);
            }
        });
    }
});

