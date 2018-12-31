package com.neuedu.controller;

import com.neuedu.pojo.Role;
import com.neuedu.service.IRoleService;
import com.neuedu.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/add_user")
public class AddUserServlet extends HttpServlet {
    IRoleService roleService = new RoleService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Role> roles = roleService.getLists();
        req.setAttribute("roles",roles);
        req.getRequestDispatcher("WEB-INF/pages/add_user.jsp").forward(req,resp);
    }
}
