base_url='http://localhost:8080';


function GetPar(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r != null){
        return decodeURIComponent(r[2]);
    }
    return null;
}

layui.define(['jquery'], function(exports) {
    var $ = layui.$,
        lau = top.layui.lau;

    //监听锚点打开选项卡
    $(document).on('click', '*[lau-href]', function () {
        var _this = $(this);
        lau.go(_this.attr('lau-href'), _this.attr('lau-title'), _this.attr('lau-icon'));
    });

    exports('common', lau);
});

// 解决Ajax异步请求 springMvc 不跳转页面的问题
$.ajaxSetup( {
    //设置ajax请求结束后的执行动作

            complete: function( xhr,data ){
                // 获取相关Http Response header
                ContentType=xhr.getResponseHeader('Content-Type');
                type=xhr.getResponseHeader('type');
                console.log(ContentType);
                console.log(type);
                if (ContentType==='text/html;charset=UTF-8'&&type==='error'){
                    console.log('无权限跳转');
                    window.location.href=base_url+'/noAuth'
                }
        }
});

