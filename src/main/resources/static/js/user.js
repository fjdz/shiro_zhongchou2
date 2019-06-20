function assignRoles(id) {
    window.location.href = "/admin/assignRole/" + id;
}

$(function () {
    var pagenum = $("#pageNum").val();
    $("#li" + pagenum).addClass("active");
});


var qx = $('.qx');

$("#quanxuan").click(function () {//给全选按钮加上点击事件
    var xz = $(this).prop("checked");//判断全选按钮的选中状态
    var ck = qx.prop("checked", xz);  //让class名为qx的选项的选中状态和全选按钮的选中状态一致。
});



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
});


//权限
// $("tbody .btn-success").click(function () {
//     console.log($(this).parents("tr").attr("id"));//获取当前tr  id
//     window.location.href = "assignRole.html";
// });


//修改
$("tbody .btn-primary").click(function () {
    var trid = $(this).parents("tr").attr("id");//获取当前tr  id
    var result = trid.substring(1);
    window.location.href = "/admin/edit/"+result;
});


//删除
$("tbody .btn-danger").click(function () {
    var con = confirm("确定删除吗，此操作不可恢复"); //在页面上弹出对话框
    var trid = $(this).parents("tr").attr("id");
    var result = trid.substring(1);
    if (con) {
        $.ajax({
            type: "POST",
            url: "/ajax/delAccount",
            data: {
                "userid": result
            },
            success: function () {
                $("#"+trid).remove();
            },
            error: function (data) {
                alert("删除失败:" + data);
            }
        });
    }
});

//多选删除
function deleteuser() {
    var con = confirm("确定删除吗，此操作不可恢复"); //在页面上弹出对话框
    console.log();
    if (con) {
        var sz = [];
        qx.each(function () {
            if ($(this).prop("checked")) {
                sz.push($(this).val());
            }
        });
        //判断选中的是否为空  为空则不进行提交操作
        if (sz.length != null) {

            //提交删除操作
            $.ajax({
                type: "POST",
                url: "/ajax/delAccountList",
                data: {
                    "userid": sz
                },
                success: function (data) {
                    alert("删除成功"+data+"个");
                    window.location.reload();
                    window.location.replace("/admin/user");
                },
                error: function (data) {
                    alert("删除失败:" + data);
                }
            });
        }

    }
}