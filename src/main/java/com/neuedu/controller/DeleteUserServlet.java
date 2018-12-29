package com.neuedu.controller;

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

@WebServlet("/delete_user")
public class DeleteUserServlet extends HttpServlet {
    IUserService userService = new UserService();
    IUserRoleService userRoleService = new UserRoleService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        userService.delete(id);
        userRoleService.delete(id);
        resp.sendRedirect("power");
    }
}
