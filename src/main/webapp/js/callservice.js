layui.define(['layer', 'form', 'tips'], function(exports) {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.$,
        tips = layui.tips;

    //ajax请求出错提示
    $(document).ajaxError(function (event, request, setting) {
        if (request.status === 200) {
            tips.error('Invalid response');
        } else {
            tips.error(request.status + ': ' + request.statusText);
        }
    });

    //提交
    $('#callService').click(function () {
        var roomNo = $('#roomNo').val();
        var serviceMsg = $('#serviceMsg').val();

        //提交中
        tips.loading('提交服务中...', 0, -1);

        if (roomNo===''){
            tips.warning('请输入房间号码');
            return false;
        }else if(serviceMsg===''){
            tips.warning('请输入你想要的服务');
            return false;
        } else(
            $.ajax({
                type:"post",

                url:base_url+'/service/addservice',
                data:{
                    'roomNo':roomNo,
                    'serviceMsg':serviceMsg,


                },
                success:function (d) {
                    if(d==="0") {
                        layer.msg('房间号错误，请重新输入房间号')
                    }else{
                        layer.msg('已呼叫，等待服务')
                    }
                }
            })
        )

    });

});
