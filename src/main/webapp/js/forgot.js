layui.define(['layer', 'form', 'tips'], function(exports) {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.$,
        tips = layui.tips;

    //刷新验证码
    var captchaImg = $('.lau-sign-captcha'), captchaSrc = captchaImg.attr('src');
    captchaImg.click(function () {
        $(this).attr('src', captchaSrc + '?_t=' + Math.random());
    });

    //刷新验证码
    var captchaImg = $('.lau-sign-captcha'), captchaSrc = captchaImg.attr('src');
    captchaImg.click(function () {
        $(this).attr('src', captchaSrc + '?_t=' + Math.random());
    });

    //ajax请求出错提示
    $(document).ajaxError(function (event, request, setting) {
        if (request.status === 200) {
            tips.error('Invalid response');
        } else {
            tips.error(request.status + ': ' + request.statusText);
        }
    });

    //登陆
    $('#forgot').click(function () {
        var username = $('#username').val();
        var password = $('#password').val();
        var repassword = $('#repassword').val();
        var captcha = $('#captcha').val();


        if (!/^[a-zA-Z0-9_]{1,16}$/.test(username)) {
            tips.warning('用户名必须为1-16位数字/字母/下划线组成');
            return false;
        } else if (!/^\S{1,16}$/.test(password)) {
            tips.warning('密码必须1-16位且不能出现空格');
            return false;
        } else if(password!=repassword){
            tips.warning('两次密码不一致');
            return false;
        } else if (!/^\S{4,}$/.test(captcha)) {
            tips.warning('验证码格式不正确');
            return false;
        } else(
            $.ajax({
                type:"post",

                url:'/user/forgot',
                data:{
                    'username':username,
                    'captcha' :captcha,
                    'newpassword':password,
                },
                success:function (d) {
                    if(d==="1"){
                        layer.msg('修改成功')
                    }else if(d==="0"){
                        layer.msg('验证码错误')
                    }else{
                        layer.msg('用户名或者密码错误')
                    }

                }
            })
        )

    });

});
