package com.neuedu.controller;

import com.neuedu.service.BrandService;
import com.neuedu.service.IBrandService;
import com.neuedu.service.IProductService;
import com.neuedu.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete_brand")
public class DeleteBrandServlet extends HttpServlet {
    IBrandService brandService = new BrandService();
    IProductService productService = new ProductService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        brandService.delete(id);
        productService.deletes(id);
        resp.sendRedirect("brand_manager");
    }
}
