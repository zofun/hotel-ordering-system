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
    $('#lockDemo').click(function () {
        var id = $('#id').val();

        //提交中
        tips.loading('删除订单中...', 0, -1);


        $.ajax({
            type:"post",

            url:base_url+'/delorderbyorderId',
            data:{
                'id':id,
            },
            success:function (d) {
                if(d==="0") {
                    layer.msg('服务器出现了一点错误，请稍后再试')
                }else{
                    layer.msg('已删除该订单')
                }
            }
        })
    });

});
