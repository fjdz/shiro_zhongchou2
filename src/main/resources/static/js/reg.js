/**
 *
 * Created by DYF on 2019/5/27.
 */


$("#inp1").change(function () {
    var A = $("#inp1").val();
    $.get("/log/regaccount",$("#form1").serialize(),function(data){
        if (data){
            $("#accountpan").after("<p id='acc1' style='color: #ff0000' >账号已被注册</p>");
        }else if (!(A.length > 0)) {
            $("#acc1").remove();
            $("#accountpan").after("<p id='acc1' style='color: #ff0000' >登陆账号不能为空</p>");
        } else {
            $("#acc1").remove();
        }
    });
});

$("#inp3").change(function () {
    var email = this.value;
    var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    $.get("/log/regemail",$("#form1").serialize(),function(data){
        if (data){
            $("#email1").remove();
            $("#emailpan").after("<p id='email1' style='color: #ff0000' >邮箱已被使用</p>");
        }else if (!reg.test(email)) {
            $("#email1").remove();
            $("#emailpan").after("<p id='email1' style='color: #ff0000' >邮箱格式不正确</p>");
        } else{
            $("#email1").remove();
        }
    });
});


function doreg() {
    $.post("/log/reguser", $("#form1").serialize(),
        function (data) {
            if (data.error=="ok") {
                location.href = "/";
            } else {
                alert("注册失败")
            }
        });
}