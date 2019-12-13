package com.bookstore.web.servlet;

import com.bookstore.domain.User;
import com.bookstore.exception.NotExistUser;
import com.bookstore.service.UserService;
import com.bookstore.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取验证码
        String activeCode = request.getParameter("activeCode");
        String code = (String) request.getSession().getAttribute("code");
        if (!activeCode.equals(code)) {
            request.setAttribute("tipCode", "验证码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        //获取表单数据
        String userEmail = request.getParameter("userEmail");
        String userPwd = request.getParameter("userPwd");
        UserService userService = new UserServiceImpl();
        try {
            //调用业务逻辑
            User user = userService.login(userEmail, userPwd);

            String remember = request.getParameter("remember");
            Cookie cookie = new Cookie("user", userEmail + "&" + userPwd);
            cookie.setPath("/");

            if (remember != null) { //判断用户时是否记住登录账户
                cookie.setMaxAge(60 * 60 * 24 * 3 * 30);
            } else {
                cookie.setMaxAge(0);
            }
            response.addCookie(cookie);
            request.getSession().setAttribute("user", user);
            //分发转向
            request.setAttribute("user", user);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (NotExistUser e) {
            request.setAttribute("fail_msg", e.getMsg());
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
