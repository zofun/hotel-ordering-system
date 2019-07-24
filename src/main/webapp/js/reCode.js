//获取验证码
function getVerify(){
    var src1=document.getElementById('imgVerify')
    src1.src = "/vccode?"+Math.random();
}
