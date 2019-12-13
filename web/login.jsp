<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/11
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link type="text/css" href="css/login.css" rel="stylesheet">
    <script type="text/javascript">
        <%--动态获取验证码--%>

        function getCode() {
            document.getElementById("code").src = "${pageContext.request.contextPath}/RegCodeServlet?time=" + new Date().getTime();
        }
    </script>
    <%
        String userEmail = "";
        String userPwd = "";
        String checked = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("user".equals(name)) {
                String value = cookie.getValue();
                String[] values = value.split("&");
                userEmail = values[0];
                userPwd = values[1];
                checked = "checked='checked'";
            }
        }
    %>
</head>
<body>
<div id="header"></div>
<div id="bg">背景图
    <div id="img_style"><label
            style="text-align: center;width: 470px;height:30px;position: absolute;margin-top: 20px">${fail_msg}</label><br>
        <form action="LoginServlet" method="post">
            <div style="margin-top: 55px;margin-left: 100px">
                <label for="userEmail">用户邮箱： </label><input id="userEmail" value="<%=userEmail%>" type="text"
                                                            name="userEmail"><span id="msg"></span><br/>
            </div>
            <div style="margin-top: 25px;margin-left: 100px">
                <label for="userPwd">用户密码： </label><input id="userPwd" type="password" name="userPwd" value="<%=userPwd%>">
            </div>
            <div style="margin-top: 25px;margin-left: 100px"><label
                    for="activeCode">验&nbsp;证&nbsp;码&nbsp;： </label><input
                    id="activeCode" type="text" name="activeCode"><span>${tipCode}</span><br/>
            </div>
            <img id="code" name="activeCode" src="RegCodeServlet" width="160px" height="30px"
                 style="margin-top: 25px;margin-left: 100px">
            <a href="javascript:getCode()"> 看不清，换一张</a><br>
            <input type="checkbox" name="remember" "<%=checked%>" style="margin-top: 10px;margin-left: 100px" >记住密码<br>
            <input type="submit" name="register" value="用户登录" id="btnOk">
        </form>
        <div style="color: lavender;margin-top: 25px;margin-left: 240px">
            <a href="register.jsp">用户注册</a> | <a href="forgetPwd.jsp">忘记密码？</a>
        </div>
    </div>
</div>
</body>
</html>
