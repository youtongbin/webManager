package com.neuedu.controller;

import com.neuedu.service.BrandService;
import com.neuedu.service.IBrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_product")
public class AddProductServlet extends HttpServlet {
    IBrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("brands",brandService.getLists());
        req.getRequestDispatcher("WEB-INF/pages/add_product.jsp").forward(req,resp);
    }
}
