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
        var interval;
        function toJump() {
            /**
             * 设置定时器，每一秒执行一次函数
             */
            interval = window.setInterval("jumpTimeChange()", 1000);
        }

        /**
         * 创建时间修改函数
         */
        function jumpTimeChange() {
            //获取jump
            var jump = document.getElementById("jump");
            //获取jump的值
            var jumpValue = jump.innerHTML;
            alert(jumpValue);
            //修改jump的值
            jumpValue = jumpValue - 1;
            if (jumpValue == 0) {   //判断jump的值是否等于0，如果为0则清除定时器，并跳转到首页
                window.clearInterval(interval);
                location.href = "index.jsp";
                return;
            }
            jump.innerHTML = jumpValue;
        }
    </script>
</head>

<body id="body" onload="toJump()">
<div id="kj">
    <%@include file="header.jsp" %>
    <div id="left_content">
        <table width="850px" border="0" cellspacing="0">
            <tr>
                <td style="padding:30px; text-align:center">
                    <table width="60%"
                           border="0" cellspacing="0" style="margin-top:70px">
                        <tr>
                            <td style="width:98px"><img
                                    src="images/IconTexto_WebDev_009.jpg" width="128" height="128"/>
                            </td>
                            <td style="padding-top:30px"><font
                                    style="font-weight:bold; color:#FF0000">注册成功,别忘记激活帐户啊</font><br/>
                                <br/> <a href="index.jsp"><span id="jump">5</span>秒后自动为您转跳回首页</a>
                            </td>
                        </tr>
                    </table>
                    <h1>&nbsp;</h1></td>
            </tr>
        </table>
        <div id="right_content">图片</div>
    </div>
    <%@include file="foot.jsp" %>
</div>
</body>
</html>
