package com.neuedu.controller;

import com.neuedu.pojo.Brand;
import com.neuedu.service.BrandService;
import com.neuedu.service.IBrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doUpdateBrand")
public class DoUpdateBrandServlet extends HttpServlet {
    IBrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String brandName = req.getParameter("brand_name");
        brandService.update(new Brand(id,brandName));
        resp.sendRedirect("brand_manager");
    }
}
