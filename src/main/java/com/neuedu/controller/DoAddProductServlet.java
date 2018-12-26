package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.BrandService;
import com.neuedu.service.IBrandService;
import com.neuedu.service.IProductService;
import com.neuedu.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
@WebServlet("/doAddProduct")
public class DoAddProductServlet extends HttpServlet {
    IProductService productService = new ProductService();
    IBrandService brandService = new BrandService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brandName = req.getParameter("select_brand");
        String productName = req.getParameter("product_name");
        Double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));

        System.out.println(brandName+""+productName+""+price+""+stock);

        Part part = req.getPart("file");
        String str = "C:\\gitHub\\webManager\\src\\main\\webapp\\img\\" + part.getSubmittedFileName();
        String url = str.substring(str.indexOf("img"));
        File file = new File(str);
        InputStream is = part.getInputStream();
        OutputStream os = new FileOutputStream(file);
        byte[] b = new byte[1024];
        int a = is.read(b,0,b.length);
        while(a != -1){
            os.write(b);
            a = is.read(b,0,b.length);
        }

        Product product = new Product(brandService.getOne(brandName).getId(),productName,price,url,stock);
        productService.addProduct(product);
        resp.sendRedirect((String)req.getSession().getAttribute("url"));
    }
}
