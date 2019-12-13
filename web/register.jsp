<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/7
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>登录书城</title>
    <link type="text/css" href="css/register.css" rel="stylesheet">
    <script type="text/javascript">
        <%--动态获取验证码--%>

        function getCode() {
            document.getElementById("code").src = "${pageContext.request.contextPath}/RegCodeServlet?time=" + new Date().getTime();
        }
    </script>
</head>

<body id="body">
<div id="kj">
    <%@include file="header.jsp" %>
    <div id="left_content">
        <form action="RegisterServlet" method="post">
            <div id="form">
                <h3>用户注册：${reg_fail}</h3>

                <div style="margin-top: -20px;">
                    <label for="userName">用&nbsp;户&nbsp;名&nbsp;：</label><input id="userName" type="text"
                                                                               name="userName"
                                                                               style="margin-top: 15px;"><span
                        id="name_tip"></span><br/>
                </div>
                <div style="margin-top: 5px;">
                    <label for="userPwd">用户密码：</label><input id="userPwd" type="password" name="userPwd">
                    <div id="pwd_tip"
                         style="text-align: left;width: 270px;height: 20px;margin-left: 240px;margin-top: -15px;position:fixed;"></div>
                    <br/>
                </div>
                <div style="margin-top: 5px;">
                    <label for="userRePwd">密码确认：</label><input id="userRePwd" type="password" name="userRePwd"><span
                        id="repwd_tip"></span><br/>
                </div>
                <div style="margin-top: 5px;">
                    <label>用户邮箱：</label><input id="userEmail" type="text"
                                               name="userEmail"><span id="msg"></span><br/>
                </div>
                <div style="margin-top: 5px;">
                    <label for="userSexMan">用户性别：</label><input id="userSexMan" type="radio" name="userSex" value="man">男
                    <input id="userSexWoman" type="radio" name="userSex" value="woman">女<br/>
                </div>
                <div style="margin-top: 5px;">
                    <label for="userPhone">联系电话：</label><input id="userPhone" type="text"
                                                               name="userPhone"><span id="tel_tip"></span><br/>
                </div>
                <div style="margin-top: 5px;">
                    <label for="userDesc">用户描述：</label><br><textarea id="userDesc" name="userDesc" rows="3"
                                                                     cols="45"></textarea><br/>
                </div>
                <div style="margin-top: 5px;">
                    <hr draggable="false"
                        style="border:1px dashed #000; height:1px;margin-top: 10px;margin-left:0px;width: 430px">
                </div>
                <div style="margin-top: 5px">注册验证</div>
                <div style="margin-top: 5px;"><label for="activeCode">验&nbsp;证&nbsp;码&nbsp;：</label><input
                        id="activeCode" type="text" name="activeCode"><span>${tipCode}</span><br/>
                </div>
                <img id="code" name="activeCode" src="RegCodeServlet" width="160px" height="30px"
                     style="margin-top: 10px;margin-left: 80px">
                <a href="javascript:getCode()">看不清，换一张</a>
            </div>

            <input type="submit" name="register" value="用户注册"
                   style="margin-left: 140px;margin-top: 10px;margin-right: 60px;">
            <input type="button" id="canc"
                   name="cancel" value="&nbsp;&nbsp;&nbsp;取&nbsp;&nbsp;消&nbsp;&nbsp;&nbsp;"
                   onclick="javascript:window.location.reload() ">

        </form>
        <div id="right_content">图片</div>
    </div>
    <%@include file="foot.jsp" %>
</div>
</body>
<script type="text/javascript" src="js/reg_code.js"></script>
<script type="text/javascript" src="js/reg_email.js"></script>
</html>
