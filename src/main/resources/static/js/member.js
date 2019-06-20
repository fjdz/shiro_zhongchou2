/**
 *
 * Created by DYF on 2019/6/1.
 */
$(function () {
    $.ajax({
        url:"/thefrontdesk/ajaxmember",
        type:"post",
        dataType:"json",
        success:function (data) {
            console.log(data);
            var h31=$("#h31");
            var sp1=$("#span1");

            if (data.state == "待审核"){
                h31.text(data.reaiName);
                sp1.text(data.state);
                sp1.css("backgroundColor","#d8851d");
                sp1.removeAttr("onclick");
            }else if(data.state == "已实名认证"){
                h31.text(data.reaiName);
                sp1.text(data.state);
                sp1.css("backgroundColor","#3dcc47");
                sp1.removeAttr("onclick");
            }else if(data.state == "审核未通过"){
                h31.text(data.reaiName);
                sp1.text(data.state);
                h31.text("请重新认证");
                sp1.css("backgroundColor","#e50003");
            }
        },
        error:function(data){
            console.log(data);
            var h31=$("#h31");
            var sp1=$("#span1");
            h31.text("未实名");
            sp1.text("未实名认证");
        }
    });
});



function spanonclick() {

    window.location.href='accttype.html'

}