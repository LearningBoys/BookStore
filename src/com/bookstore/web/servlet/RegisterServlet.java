package com.bookstore.web.servlet;

import com.bookstore.domain.User;
import com.bookstore.exception.IsExistUser;
import com.bookstore.service.UserService;
import com.bookstore.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = (String) request.getSession().getAttribute("code");
        String activeCode = request.getParameter("activeCode");
        System.out.println(code + activeCode);
        if (!code.equals(activeCode)) {
            request.setAttribute("codeTip", "验证码不一致！");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }
        try {
            //获取表单数据并进行封装
            User user = new User();
            BeanUtils.populate(user, request.getParameterMap());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setRegisterTime(sdf.format(new Date()));
            user.setActiveCode(UUID.randomUUID().toString());//手动设置激活码
            //调用业务
            UserService userService = new UserServiceImpl();
            System.out.println(user.toString());
            userService.register(user);
            //分发转向
            request.setAttribute("user",user);
            request.getRequestDispatcher("registerSucess.jsp").forward(request, response);
        } catch (IsExistUser e) {
            request.setAttribute("reg_fail", e.getMsg());
            request.getRequestDispatcher("register.jsp").forward(request, response);
            System.out.println(e.getMsg());
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
