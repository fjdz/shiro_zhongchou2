/**
 *
 * Created by DYF on 2019/5/29.
 */
// 发送验证码倒计时60s
$(function () {
    var btn = $("#tel_btn");
    $(function () {
        btn.click(settime);
    })
    var countdown = 5;//倒计时总时间，为了演示效果，设为5秒，一般都是60s
    function settime() {
        if (countdown == 0) {
            btn.attr("disabled", false);
            btn.html("获取验证码");
            btn.removeClass("disabled");
            countdown = 5;
            return;
        } else {
            btn.addClass("disabled");
            btn.attr("disabled", true);
            btn.html("重新发送(" + countdown + ")");
            countdown--;
        }
        setTimeout(settime, 1000);
    }
});

ifNull("#realname","真实名称不能为空","realname1");
ifNull("#cardnum","身份证号码不能为空","cardnum1");
ifNull("#tel","电话号码不能为空","tel1");


function ifNull(a,b,idd) {
    $(a).change(function () {
        var B = $(a).val();
        if (!(B.length > 0)) {
            $("#"+idd).remove();
            $(a).after("<p id="+idd+" style='color:red'>"+b+"</p>");
        } else {
            $("#"+idd).remove();
        }
    });
}

$("#exampleInputEmail1").change(function () {
    var exam=$("#exampleInputEmail1").val();
    $.ajax({
        url:"/thefrontdesk/isyzm",
        type:"post",
        data:{"exam":exam},
        dataType:"json",
        success:function (r) {
            if(r==200){
                $("#pyzm").remove();
                $("#exampleInputEmail1").after("<p id='pyzm' style='color: #009900' >验证成功</p>");
            }else {
                $("#pyzm").remove();
                $("#exampleInputEmail1").after("<p id='pyzm' style='color: #ff0000' >验证码错误请重新输入</p>");
            }

        }
    });
});

function fasong() {
    var exam=$("#inputemail").val();
    var p1= $("#p1");
    p1.css("display","none");
    $.ajax({
        url:"sendyzm",
        type:"post",
        data:{"exam":exam},
        dataType:"json",
        success:function (r) {
            if(r==200){
                p1.css("display","none");
                p1.fadeIn("slow");
            }else {
                alert("邮箱格式有误，请重新填写发送")
            }

        }
    });

}

function submitall() {
    $.ajax({
        url:"/thefrontdesk/suball",
        type:"post",
        dataType:"json",
        success:function (isqx) {
            if(isqx){
                location.href="/thefrontdesk/member";
            }
        }
    });
}