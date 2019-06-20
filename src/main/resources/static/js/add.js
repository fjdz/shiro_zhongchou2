/**
 *
 * Created by DYF on 2019/5/28.
 */
var Q = $("#exampleInputPassword");

Q.change(function () {
    var A = Q.val();
    $.get("/ajax/regAccount", $("#myForm").serialize(), function (data) {
        var w = $("#acc1");
        if (data) {
            console.log(data + "hhhhbhbhhbh");
            w.remove();
            Q.after("<p id='acc1' style='color: #ff0000' >账号已被使用</p>");
        } else if (!(A.length > 0)) {
            w.remove();
            Q.after("<p id='acc1' style='color: #ff0000' >登陆账号不能为空</p>");
        } else {
            w.remove();
        }
    });
});

var em = $("#exampleInputEmail1");

em.change(function () {
    var C = $("#exampleInputEmail1").val();
    var email = this.value;
    var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    $.get("/ajax/regemail", $("#myForm").serialize(), function (data) {
        console.log(data);
        var emrm = $("#email1");
        if (data) {
            emrm.remove();
            em.after("<p id='email1' style='color: #ff0000' >邮箱已被使用</p>");
        } else if (!(C.length > 0)) {
            emrm.remove();
            em.after("<p id='email1' style='color: #ff0000' >邮箱地址不能为空</p>");
        } else if (!reg.test(email)) {
            emrm.remove();
            em.after("<p id='email1' style='color: #ff0000' >邮箱格式不正确</p>");
        } else {
            emrm.remove();
        }
    });
});

$("#exampleInputPassword1").change(function () {
    var B = $("#exampleInputPassword1").val();
    if (!(B.length > 0)) {
        $("#acc").remove();
        $("#exampleInputPassword1").after("<p id='acc' style='color: #ff0000' >用户名称不能为空</p>");
    } else {
        $("#acc").remove();
    }
});


function formsubment() {
    var A = $("#exampleInputPassword").val();
    var C = $("#exampleInputEmail1").val();
    var B = $("#exampleInputPassword1").val();
    if ((A.length > 0) & (B.length > 0) & (C.length > 0)) {
        $.post("/admin/ajax/addAccount", $("#myForm").serialize(),
            function (data) {
                if (data) {
                    location.href = "/admin/user";
                } else {
                    alert("添加失败")
                }
            });
    }
}


function updatauser(id) {
    var A = $("#exampleInputPassword").val();
    var C = $("#exampleInputEmail1").val();
    var B = $("#exampleInputPassword1").val();
    if ((A.length > 0) && (B.length > 0) && (C.length > 0)) {
        $.post("/admin/ajax/upacc", $("#myForm").serialize() + "&userid=" + id,
            function (data) {
                if (data) {
                    location.href = "/admin/user";
                } else {
                    alert("修改失败");
                }
            });
    }
}

function formReset() {
    document.getElementById("myForm").reset();
    $("#email1").remove();
    $("#acc1").remove();
    $("#acc").remove();
}