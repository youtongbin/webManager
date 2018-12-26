package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import com.neuedu.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    IProductService productService = new ProductService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = productService.getOne(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("product",product);
        req.getRequestDispatcher("WEB-INF/pages/update.jsp").forward(req,resp);
    }
}
