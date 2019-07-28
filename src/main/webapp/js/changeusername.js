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
    $('#setmyinfo').click(function () {
        var id = $('#id').val();
        var username = $('#username').val();



        if (username=='') {
            tips.warning('请输入用户名');
            return false;
        }else(
            $.ajax({
                type:"post",

                url:'/user/changeUserName',
                data:{
                    'id':id,
                    'username':username,

                },
                success:function (d) {
                    if(d==="1") {
                        layer.msg('修改成功');
                    }else if(d ==="2"){
                        layer.msg('该用户已存在');
                    }else{
                        layui.msg('服务器出现了一点错误，请稍后再试');
                    }
                }
            })
        )

    });
    exports('changeusername',{})
});
