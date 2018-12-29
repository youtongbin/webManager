package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.IRoleService;
import com.neuedu.service.IUserService;
import com.neuedu.service.RoleService;
import com.neuedu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update_power")
public class UpdatePowerServlet extends HttpServlet {
    IRoleService roleService = new RoleService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String roleName = req.getParameter("role_name");

        req.setAttribute("id",id);
        req.setAttribute("username",username);
        req.setAttribute("role_name",roleName);
        req.setAttribute("roles",roleService.getLists());

        req.getRequestDispatcher("WEB-INF/pages/update_power.jsp").forward(req,resp);
    }
}
