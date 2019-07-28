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

    //ajax请求出错提示
    $(document).ajaxError(function (event, request, setting) {
        if (request.status === 200) {
            tips.error('Invalid response');
        } else {
            tips.error(request.status + ': ' + request.statusText);
        }
    });

    //获取手机验证码
    $('#register').click(function () {
        var phone = $('#phone').val();
        var username = $('#username').val();
        var name = $('#name').val();
        var password = $('#password').val();
        var repassword = $('#repassword').val();
        var captcha = $('#captcha').val();

        if (!/^1\d{10}$/.test(phone)) {
            return tips.warning('请输入正确的手机号码');
            return false;
        }else if(!/^[a-zA-Z0-9_]{1,16}$/.test(username)){
            return tips.warning('用户名必须为1-16位数字/字母/下划线组成');
            return false;
        }else if (!/^\S{1,16}$/.test(password)) {
            tips.warning('密码必须1-12位且不能出现空格');
            return false;
        }else if(password!=repassword){
            tips.warning('两次密码不一致');
        }else if (!/^\S{4,}$/.test(captcha)) {
            tips.warning('验证码格式不正确');
            return false;
        }else(
            $.ajax({
                type:"post",

                url:'/user/register',
                data:{
                    'name':name,
                    'username':username,
                    'password':password,
                    'captcha' :captcha,

                },
                success:function (d) {
                    if(d==="1"){
                        layer.msg('注册成功')
                    }else if(d==="2"){
                        layer.msg('验证码错误')
                    }else{
                        layer.msg('用户名或者密码错误')
                    }

                }
            })
        )


    });

    //弹出用户注册协议
    $('.lau-sign-lic').click(function () {
        var license = $('input[name="license"]');
        layer.open({
            title: 'HOTEL 官方站 网站服务条款',
            type: 1,
            area: ['700px', '450px'],
            content: $('#license').html(),
            btn: ['同意', '拒绝'],
            btnAlign: 'c',
            yes: function (index, layero) {
                license.prop('checked', true);
                form.render('checkbox');
                layer.close(index);
            },
            btn2: function (index, layero) {
                license.prop('checked', false);
                form.render('checkbox');
                layer.alert('您拒绝了我们的协议，可能需要吊起来打');
            }
        });
    });
    exports('register',{})
});
