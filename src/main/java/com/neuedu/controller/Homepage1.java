package com.neuedu.controller;

import com.neuedu.pojo.TransPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/homepage1")
public class Homepage1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("WEB-INF/pages/homepage1.jsp").forward(req,resp);

        TransPage.checkSession(req,resp);

    }
}