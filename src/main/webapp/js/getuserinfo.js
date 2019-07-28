layui.define(['layer', 'form', 'tips'], function(exports) {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.$,
        tips = layui.tips;

    $.ajax({
        type:"get",
        url:base_url+"/user/getUserInfo",

        success:function (d) {
            var user = '<%=session.getAttribute("User")%>'
            username = d.username;
            console.log(username);
            $('.uername').innerHTML = username;
            $('#username').text(username);

        }
    });
    exports('getuserinfo',{})
});