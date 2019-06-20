/**
 *
 * Created by DYF on 2019/5/30.
 */

//设置选择框的选中状态
$(function () {
    $.ajax({
        url:"/admin/ajaxgettype",
        type:"post",
        dataType:"json",
        success:function (data) {
            $(data).each(function(index,element){
                var typenumber = element.typeNumber;
                var zzid = element.zzid;
                var inputid = "#p"+typenumber+"i"+zzid;
                $(inputid).prop('checked',true);
            });
        }
    });
});

function daloradd(id) {
    var typeNumber;
    var zZID;
    var m = new RegExp('.*?(\\d+).*?(\\d+)', ["i"]).exec(id);
    if (m != null) {
        typeNumber = m[1];
        zZID = m[2];
    }
    var checkbox = $("#" + id).prop("checked");
    if (checkbox) {
        setZZRZ(typeNumber,zZID);
    } else {
        resetZZRZ(typeNumber,zZID);
    }
}

function setZZRZ(tNumber,zID) {
    $.ajax({
        url:"/admin/daloradd/set",
        type:"post",
        data:{
            "typeNumber":tNumber,
            "zZID":zID
        },
        dataType:"json",
        success:function (r) {
            if(r==200){
                var pyzm = $("#pyzm");
                pyzm.fadeIn(500);
                pyzm.fadeOut(500);
            }
        }
    });
}

function resetZZRZ(tNumber,zID) {
        $.ajax({
        url:"/admin/daloradd/reset",
        type:"post",
        data:{
            "typeNumber":tNumber,
            "zZID":zID
        },
        dataType:"json",
        success:function (r) {
            if(r==200){
                var pyzm = $("#pyzm");
                pyzm.fadeIn(500);
                pyzm.fadeOut(500);
            }
        }
    });
}





