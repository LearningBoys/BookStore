var email = document.getElementById("userEmail");
var msg = document.getElementById("msg");

function getXMLHttpRequest() {
    //�ж�������汾
    var xmlHttp;
    if (window.XMLHttpRequest) { //code for IE7+, Firefox, Chrome, Opera, Safari
        xmlHttp = new XMLHttpRequest();
    } else { // code for IE6, IE5
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlHttp;
}

function activeEmail() {
    //2����XMLHttpRequest����
    var xmlHttpRequest = getXMLHttpRequest();
    email.onblur = function () {
        //4������
        xmlHttpRequest.onreadystatechange = function () {
            if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
                if (email.value == "") {
                    msg.innerHTML = "";
                } else {
                    msg.innerHTML = xmlHttpRequest.responseText;
                }
            }
        }
        //3��������
        xmlHttpRequest.open("get", "EmailServlet?userEmail=" + email.value);
        //4��������
        xmlHttpRequest.send(null);
    }
}

//�����ʽ��֤
email.onkeydown = function () {
    //�Ѻ���ʾ
    msg.innerHTML = "��������ȷ�����"
    msg.style.color = "green";
};
email.onkeyup = function () {
    //������ʾ
    var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if (reg.test(email.value)) {
        msg.innerHTML = "�����ʽ��ȷ";
        activeEmail();
    } else {
        if (email.value == "") {
            msg.innerHTML = "";
        } else {
            msg.innerHTML = "�����ʽ����";
        }
    }
};
