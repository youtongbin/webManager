package com.neuedu.pojo;

import myTools.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

/**
 * cookie和session完成数据存储和页面保护、跳转
 */
public class TransPage extends HttpServlet {
    public static void checkSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");
        String url = (String)session.getAttribute("url");

        if (username != null && url != null){
            //会话未失效时
            if (url.equals(req.getServletPath().substring(1))){
                //如果session中URL与网址栏请求相同，显示请求信息
                session.setAttribute("username",username);
                session.setAttribute("url",url);
                req.getRequestDispatcher("WEB-INF/pages/" + url + ".jsp").forward(req,resp);
            }else {
                //不相同跳入登录页
                resp.sendRedirect("login");
            }

        }else {
            //会话不存在，跳登录页
            resp.sendRedirect("login");
        }

    }

}
