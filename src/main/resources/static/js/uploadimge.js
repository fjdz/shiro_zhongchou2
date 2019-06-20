/**
 *
 * Created by DYF on 2019/5/31.
 */

$(function(){
   console.log($("ZzIg")) ;
   console.log($("ZzImg")) ;
});

function uploadTrainProduct(){
    var formData = new FormData($("#form1")[0]);  //重点：要用这种方法接收表单的参数
    console.log(formData);
    $.ajax({
        url: '/thefrontdesk/uploadTrainProduct' ,
        type: 'POST',
        data : formData,
        // 告诉jQuery不要去处理发送的数据
        processData : false,
        // 告诉jQuery不要去设置Content-Type请求头
        contentType : false,
        async : false,
        success: function (returndata) {
            alert(returndata);
        }
    });
}