/**
 *
 * Created by DYF on 2019/6/3.
 */
$(function () {
    $.get("/admin/updata/typenumber", function (data) {
        $.each(data, function (index, idzzimg) {
            console.log(idzzimg);
            var i = $("#label" + index);
            i.empty();
            i.append(idzzimg.zzname);
        })
    });
});


function pass() {
    var shyj = $("#shyjform").serialize();
    console.log(shyj);
    $.ajax({
        url:"/admin/updata/pass",
        type:"post",
        dataType:"json",
        data:shyj,
        success:function (data) {
            if (data >= 1){
                var i = $("#state");
                i.empty();
                i.append("审核状态 : 已实名认证")
            }
        }
    });
}

function refuse() {
    var shyj = $("#shyjform").serialize();
    $.ajax({
        url:"/admin/updata/refuse",
        type:"post",
        dataType:"json",
        data:shyj,
        success:function (data) {
            if (data != null){
                console.log(data)
                var i = $("#opinion1");
                i.empty();
                i.append("审核意见 : "+data.opinion)
            }
        }
    });
}



