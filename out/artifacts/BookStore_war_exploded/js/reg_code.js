var userName = document.getElementById("userName");
var name_tip = document.getElementById("name_tip");
var pwd = document.getElementById("userPwd");
var pwd_tip = document.getElementById("pwd_tip");
var re_pwd = document.getElementById("userRePwd");
var re_pwd_tip = document.getElementById("repwd_tip");
var tel = document.getElementById("userPhone");
var tel_tip = document.getElementById("tel_tip");

//电话号码格式验证
tel.onfocus = function () {
    //友好提示
    tel_tip.innerHTML = "请输入11位正确的手机号"
    tel_tip.style.color = "green";
};
tel.onblur = function () {
    //错误提示
    if (/^1[345678]\d{9}$/.test(tel.value)) {
        tel_tip.innerHTML = "号码正确";
    } else {
        if(tel.value==""){
            tel_tip.innerHTML = "";
        }else {
            tel_tip.innerHTML = "电话号码错误,请重写";
        }
    }
};
//进行密码确认
re_pwd.onkeydown = function () {
    //友好提示
    re_pwd_tip.innerHTML = "请确认密码"
    re_pwd_tip.style.color = "green";
};
re_pwd.onblur = function(){
    if(re_pwd.value==""){
        re_pwd_tip.innerHTML = "";
    }
}
re_pwd.onkeyup = function () {
    //错误提示
    if (pwd.value === re_pwd.value) {
        re_pwd_tip.innerHTML = "密码正确";
    } else {
        re_pwd_tip.innerHTML = "两次密码不一致"
    }
};
//进行密码格式验证
pwd.onfocus = function () {
    //友好提示
    pwd_tip.innerHTML = "密码长度为8-20位,密码须包含字母、数字、特殊字符（@,#,$,%,&,*）"
    pwd_tip.style.color = "green";
};
pwd.onblur = function(){
    if(pwd.value==""){
        pwd_tip.innerHTML = "";
    }
}
pwd.onkeyup = function () {
    //错误提示
    if (pwd.value.length < 8 || pwd.value.length > 20) {

            pwd_tip.innerHTML = "密码长度应该为8-20位,应包含特殊字符（@,#,$,%,&,*）";

    } else if (!(/[@#$%&*]/.test(pwd.value))) { //判断密码是否包含至少一位特殊字符
        pwd_tip.innerHTML = "密码应该包含特殊字符（@,#,$,%,&,*）";
    } else if (/[\w]{6,19}$/) { //判断密码是否包含6-19位字母、数字
        pwd_tip.innerHTML = "密码正确";
    }
};
userName.onfocus = function () {
    //友好提示
    name_tip.innerHTML = "请输入真实用户名";
    name_tip.style.color = "green";
};
userName.onblur = function () {
    //错误提示
    if(userName.value==""){
    name_tip.innerHTML = "";
    }else {
        name_tip.innerHTML = "用户正确";
    }
};

