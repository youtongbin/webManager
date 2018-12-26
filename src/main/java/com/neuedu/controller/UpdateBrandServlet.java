package com.neuedu.controller;

import com.neuedu.service.BrandService;
import com.neuedu.service.IBrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update_brand")
public class UpdateBrandServlet extends HttpServlet {
    IBrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("brand",brandService.getOne(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("WEB-INF/pages/update_brand.jsp").forward(req,resp);
    }
}
