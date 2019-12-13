package com.bookstore.web.servlet;

import com.bookstore.domain.User;
import com.bookstore.service.UserService;
import com.bookstore.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取用户名
        String userEmail = request.getParameter("userEmail");
        PrintWriter out = response.getWriter();
        UserService service = new UserServiceImpl();
        List<User> users = service.findUserByUserByEmail(userEmail);
        if (users.size()>0) {
            out.print("邮箱已存在");
        } else {
            out.print("邮箱正确");
        }
    }
}
