package com.bookstore.web.filter;

import com.bookstore.domain.User;
import com.bookstore.exception.NotExistUser;
import com.bookstore.service.UserService;
import com.bookstore.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
//        request.setCharacterEncoding("UTF-8");
//        chain.doFilter(request, response);
        //处理服务器乱码
        HttpServletRequest requestWrapper = new EncodingFilterServletRequestWrapper(request);
        //处理相应乱码
        response.setContentType("text/html;charset=UTF-8");


        //用户自动登录
        //获取路径
        String requestURI = request.getRequestURI();
        String requestContextPath = request.getContextPath();
        String path = requestURI.substring(requestContextPath.length());
        System.out.println(path);
        UserService userService = new UserServiceImpl();
        if (!(path.equals("/login.jsp") || path.equals("/LoginServlet"))) {  //如果用户不进行登录，直接访问到主页，程序开始自动登陆操作
            User user = (User) request.getSession().getAttribute("userInfo");
            if (user == null) {  //如果user==null；说明用户初次登录或用户以前登录未存储用户信息
                Cookie[] cookies = request.getCookies(); //获取客户端Cookie
                //从客户端的cookies中找到需要的user对象信息
                String userEmail = "";
                String userPwd = "";
                for (Cookie cookie : cookies) {
                    if ("user".equals(cookie.getName())) {    //判断客户端中是否有存储user对象信息
                        String value = cookie.getValue();
                        String[] values = value.split("&");
                        userEmail = values[0];
                        userPwd = values[1];
                    }
                }
                //进行登录操作
                try {
                    User u = userService.login(userEmail, userPwd);
                    if (u != null) {
                        request.getSession().setAttribute("user", u);
                    }
                } catch (NotExistUser notExistUser) {
                    notExistUser.printStackTrace();
                }
            } else {
                try {
                    User u = userService.login(user.getUserEmail(), user.getUserPwd());
                    if (u != null) {
                        request.getSession().setAttribute("user", u);
                    }
                } catch (NotExistUser notExistUser) {
                    notExistUser.printStackTrace();
                }
            }
        }
        chain.doFilter(requestWrapper, resp);
    }

    public void init(FilterConfig config) throws ServletException {
    }

}


