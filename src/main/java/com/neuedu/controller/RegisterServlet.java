package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserRoleService;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserRoleService;
import com.neuedu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    IUserService userService = new UserService();
    IUserRoleService userRoleService = new UserRoleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwords = req.getParameter("confirm_password");
        String tele = req.getParameter("phone_number");
        System.out.println(username + " "+ password);

//        resp.getWriter().write("1");

        if (!username.matches("[ ]*") && !password.matches("[ ]*")){
            User u = userService.getOne(username);
            if (u == null){
                if (password.equals(passwords)){
                    User newUser = new User(username,password,tele);
                    int addUserResult = userService.add(newUser);
//                    int addUserResult = 1;
                    if (addUserResult == 1){
                        //添加成功时，重新获取数据,获得用户id
                        Integer newUserId = userService.getOne(username).getId();
                        //通过用户id，在user_role表中调价一条数据，role_id默认为最低（1）
                        Integer roleId = 1;
                        int addUserRoleResult = userRoleService.add(newUserId,roleId);
                        //注册成功，前往登录
                        resp.getWriter().write("1");
//                        resp.sendRedirect("login");
                    }else {
                        //注册失败
                        resp.getWriter().write("2");
                    }
                }else {
                    //两次密码输入不一致
                    resp.getWriter().write("3");
                }
            }else {
                //用户已存在
                resp.getWriter().write("4");
            }
        }else {
            //用户名或密码输入为空
            resp.getWriter().write("5");
        }

    }
}
