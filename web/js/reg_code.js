var userName = document.getElementById("userName");
var name_tip = document.getElementById("name_tip");
var pwd = document.getElementById("userPwd");
var pwd_tip = document.getElementById("pwd_tip");
var re_pwd = document.getElementById("userRePwd");
var re_pwd_tip = document.getElementById("repwd_tip");
var tel = document.getElementById("userPhone");
var tel_tip = document.getElementById("tel_tip");

//�绰�����ʽ��֤
tel.onfocus = function () {
    //�Ѻ���ʾ
    tel_tip.innerHTML = "������11λ��ȷ���ֻ���"
    tel_tip.style.color = "green";
};
tel.onblur = function () {
    //������ʾ
    if (/^1[345678]\d{9}$/.test(tel.value)) {
        tel_tip.innerHTML = "������ȷ";
    } else {
        if(tel.value==""){
            tel_tip.innerHTML = "";
        }else {
            tel_tip.innerHTML = "�绰�������,����д";
        }
    }
};
//��������ȷ��
re_pwd.onkeydown = function () {
    //�Ѻ���ʾ
    re_pwd_tip.innerHTML = "��ȷ������"
    re_pwd_tip.style.color = "green";
};
re_pwd.onblur = function(){
    if(re_pwd.value==""){
        re_pwd_tip.innerHTML = "";
    }
}
re_pwd.onkeyup = function () {
    //������ʾ
    if (pwd.value === re_pwd.value) {
        re_pwd_tip.innerHTML = "������ȷ";
    } else {
        re_pwd_tip.innerHTML = "�������벻һ��"
    }
};
//���������ʽ��֤
pwd.onfocus = function () {
    //�Ѻ���ʾ
    pwd_tip.innerHTML = "���볤��Ϊ8-20λ,�����������ĸ�����֡������ַ���@,#,$,%,&,*��"
    pwd_tip.style.color = "green";
};
pwd.onblur = function(){
    if(pwd.value==""){
        pwd_tip.innerHTML = "";
    }
}
pwd.onkeyup = function () {
    //������ʾ
    if (pwd.value.length < 8 || pwd.value.length > 20) {

            pwd_tip.innerHTML = "���볤��Ӧ��Ϊ8-20λ,Ӧ���������ַ���@,#,$,%,&,*��";

    } else if (!(/[@#$%&*]/.test(pwd.value))) { //�ж������Ƿ��������һλ�����ַ�
        pwd_tip.innerHTML = "����Ӧ�ð��������ַ���@,#,$,%,&,*��";
    } else if (/[\w]{6,19}$/) { //�ж������Ƿ����6-19λ��ĸ������
        pwd_tip.innerHTML = "������ȷ";
    }
};
userName.onfocus = function () {
    //�Ѻ���ʾ
    name_tip.innerHTML = "��������ʵ�û���";
    name_tip.style.color = "green";
};
userName.onblur = function () {
    //������ʾ
    if(userName.value==""){
    name_tip.innerHTML = "";
    }else {
        name_tip.innerHTML = "�û���ȷ";
    }
};

