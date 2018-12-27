package com.neuedu.controller;

import com.neuedu.pojo.ProductsData;
import com.neuedu.service.IProductService;
import com.neuedu.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@MultipartConfig
@WebServlet("/product_list")
public class ProductListServlet extends HttpServlet {
    IProductService productService = new ProductService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));
        String key = req.getParameter("key");

        int pageSize = 6;
//        int pageSize = 1;

        if (key == null || key.matches("[ ]*")){
            //key为空，显示全部信息
            ProductsData data = productService.getLists(pageNo,pageSize);
            data.setUrl((String)session.getAttribute("url"),"");

            req.setAttribute("data",data);
            req.getRequestDispatcher("WEB-INF/pages/" + session.getAttribute("url") + ".jsp").forward(req,resp);
        }else {
            String params = "&key=" + key;
            ProductsData data = productService.getLists(pageNo,pageSize,key);
            data.setUrl((String)session.getAttribute("url"),params);

            req.setAttribute("data",data);
            req.getRequestDispatcher("WEB-INF/pages/" + session.getAttribute("url") + ".jsp").forward(req,resp);
        }

    }

}
