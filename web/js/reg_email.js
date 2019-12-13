var email = document.getElementById("userEmail");
var msg = document.getElementById("msg");

function getXMLHttpRequest() {
    //判断浏览器版本
    var xmlHttp;
    if (window.XMLHttpRequest) { //code for IE7+, Firefox, Chrome, Opera, Safari
        xmlHttp = new XMLHttpRequest();
    } else { // code for IE6, IE5
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlHttp;
}

function activeEmail() {
    //2创建XMLHttpRequest对象
    var xmlHttpRequest = getXMLHttpRequest();
    email.onblur = function () {
        //4处理结果
        xmlHttpRequest.onreadystatechange = function () {
            if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
                if (email.value == "") {
                    msg.innerHTML = "";
                } else {
                    msg.innerHTML = xmlHttpRequest.responseText;
                }
            }
        }
        //3创建连接
        xmlHttpRequest.open("get", "EmailServlet?userEmail=" + email.value);
        //4发送请求
        xmlHttpRequest.send(null);
    }
}

//邮箱格式验证
email.onkeydown = function () {
    //友好提示
    msg.innerHTML = "请输入正确邮箱号"
    msg.style.color = "green";
};
email.onkeyup = function () {
    //错误提示
    var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if (reg.test(email.value)) {
        msg.innerHTML = "邮箱格式正确";
        activeEmail();
    } else {
        if (email.value == "") {
            msg.innerHTML = "";
        } else {
            msg.innerHTML = "邮箱格式错误";
        }
    }
};
