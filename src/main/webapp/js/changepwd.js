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
        var username = $('#username').val();
        var password = $('#password').val();

        //提交中
        tips.loading('修改密码中...', 0, -1);

        if (password===''){
            tips.warning('请输入你想要修改的密码');
            return false;
        } else(
            $.ajax({
                type:"post",

                url:base_url+'/user/changePwd',
                data:{
                    'username':username,
                    'password':password,


                },
                success:function (d) {
                    if(d==="0") {
                        layer.msg('服务器出现了一点错误，请稍后再试')
                    }else{
                        layer.msg('修改完成')
                    }
                }
            })
        )

    });

});
