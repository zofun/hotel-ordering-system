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
        var captcha = $('#captcha').val();
        var password = $('#password').val();
        var repasssword = $('#repassword').val();


        if (!/^\S{4,}$/.test(captcha)) {
            tips.warning('验证码格式不正确');
            return false;
        }else if(password!=repasssword){
            tips.warning('两次输入的密码不一致，请重新输入');
            return false;
        }else(
            $.ajax({
                type:"post",

                url:base_url+'/user/changeUserPwd',
                data:{
                    'username':username,
                    'password':password,
                    'captcha':captcha,


                },
                success:function (d) {
                    if(d==="1") {
                        layer.msg('修改完成,请重新登陆')
                        window.location.href=base_url+'/html/login.html'
                    }else if(d ==="2"){
                        layer.msg('验证码错误');
                    }else{
                        layui.msg('服务器出现了一点错误，请稍后再试');
                    }
                }
            })
        )

    });
    exports('userchangepwd',{})
});
