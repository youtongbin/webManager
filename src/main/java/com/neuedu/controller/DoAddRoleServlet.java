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

@WebServlet("/doAddRole")
public class DoAddRoleServlet extends HttpServlet {
    IRoleService roleService = new RoleService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleName = req.getParameter("role_name");
        if (!roleName.matches("[ ]*") && roleService.getOne(roleName) == null){
            roleService.add(new Role(roleName));
        }else {
            req.getRequestDispatcher("add_role").forward(req,resp);
        }
        resp.sendRedirect("power");
    }
}
