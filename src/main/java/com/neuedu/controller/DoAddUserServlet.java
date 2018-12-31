package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doAddUser")
public class DoAddUserServlet extends HttpServlet {
    IUserService userService = new UserService();
    IRoleService roleService = new RoleService();
    IUserRoleService userRoleService = new UserRoleService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String power = req.getParameter("select_power");
        if (!username.matches("[ ]*") && userService.getOne(username) == null
                && !password.matches("[ ]*") && power != null){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userService.add(user);

            Integer userId = userService.getOne(username).getId();
            Integer roleId = roleService.getOne(power).getId();

            for (int i = 1;i <= roleId;i++){
                userRoleService.add(userId,i);
            }
            resp.sendRedirect("power");
        }
    }
}
