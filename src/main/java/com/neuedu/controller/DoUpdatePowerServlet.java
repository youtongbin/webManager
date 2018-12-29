package com.neuedu.controller;

import com.neuedu.service.IRoleService;
import com.neuedu.service.IUserRoleService;
import com.neuedu.service.RoleService;
import com.neuedu.service.UserRoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doUpdatePower")
public class DoUpdatePowerServlet extends HttpServlet {
    IUserRoleService userRoleService = new UserRoleService();
    IRoleService roleService = new RoleService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String roleName = req.getParameter("select_power");

        /**
         * 修改用户权限表，
         * 获取该用户原来的权限等级，
         * 与新的权限等级进行比较
         * 若权限提高，则插入新的用户权限信息，从旧权限开始，到当前新权限等级结束
         * 若权限降低，则删除用户权限表中的信息，删除该用户所有权限大于当前新权限的所有数据
         * 若没有改变，则不做处理
         */
        Integer maxRoleId = userRoleService.getLists(id).get(0).getRoleId();
        System.out.println(maxRoleId);
        Integer newRoleId = roleService.getOne(roleName).getId();
        System.out.println(newRoleId);


        if ((newRoleId > maxRoleId) && newRoleId < (roleService.getOne("超级管理员").getId())){
            for (int i = maxRoleId + 1;i <= newRoleId;i++){
                userRoleService.add(id,i);
            }
        }else if (newRoleId < maxRoleId){
            for (int i = maxRoleId;i > newRoleId;i--){
                userRoleService.delete(id,maxRoleId);
            }
        }

        resp.sendRedirect("power");
    }
}
