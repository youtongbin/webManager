package com.neuedu.controller;

import com.neuedu.pojo.ProductsData;
import com.neuedu.service.IProductService;
import com.neuedu.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/product_list")
public class ProductListServlet extends HttpServlet {
    IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
        int pageSize = 6;

        ProductsData data = productService.getLists(pageNo,pageSize);
        System.out.println(data);
        data.setUrl("product_list");
        req.setAttribute("data",data);


        req.getRequestDispatcher("WEB-INF/pages/" + req.getSession().getAttribute("url") + ".jsp").forward(req,resp);

//        resp.getWriter().write((String)req.getAttribute("url"));

//        req.getRequestDispatcher("WEB-INF/pages/" + req.getAttribute("url") + ".jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
