package com.neuedu.controller;

import com.neuedu.pojo.Role;
import com.neuedu.pojo.User;
import com.neuedu.pojo.UserRole;
import com.neuedu.pojo.UsersRole;
import com.neuedu.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/power")
public class PowerServlet extends HttpServlet {
    IUserRoleService userRoleService = new UserRoleService();
    IRoleService roleService = new RoleService();
    IUserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //角色名、用户列表
        List<UsersRole> usersRoles = new ArrayList<>();
        //角色表
        List<Role> roles = roleService.getLists();
        //用户表
        List<User> users = userService.getLists();

        for (User user:users
             ) {
            /**
             * 用户表获取id
             * 用户角色表获取用户id对应的角色id表（从大到小排列）
             * 取角色最大权限对应角色id
             * 角色表获取角色名
             */
            Integer userId = user.getId();
            UserRole maxRole = userRoleService.getLists(userId).get(0);
            Integer maxRoleId = maxRole.getRoleId();
            String roleName = roleService.getOne(maxRoleId).getRoleName();

            usersRoles.add(new UsersRole(user,roleName));
        }

        req.setAttribute("roles",roleService.getLists());
        req.setAttribute("users_roles",usersRoles);
        req.getRequestDispatcher("WEB-INF/pages/power.jsp").forward(req,resp);
    }
}
