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
import java.util.List;

@WebServlet("/brand_manager")
public class BrandManagerServlet extends HttpServlet {
    IBrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = brandService.getLists();
        req.setAttribute("brands",brands);

        req.getRequestDispatcher("WEB-INF/pages/brand_manager.jsp").forward(req,resp);
    }
}
