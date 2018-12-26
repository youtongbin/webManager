package com.neuedu.controller;

import com.neuedu.service.IProductService;
import com.neuedu.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    IProductService productService = new ProductService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect((String)req.getSession().getAttribute("url"));
    }
}
