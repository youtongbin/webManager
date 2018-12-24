package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/update_personal_info")
public class UpdatePersonalInfoServlet extends HttpServlet {
    private IUserService userService = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");
        String url = (String)session.getAttribute("url");
        if (username != null && url != null){
            //会话未失效时
            Integer userId = Integer.parseInt(req.getParameter("user_id"));
            String nUsername = req.getParameter("username");
            String nPassword = req.getParameter("password");
            String nPasswords = req.getParameter("passwords");
            String nTele = req.getParameter("tele");

            if (!nUsername.matches("[ ]*") && !nPassword.matches("[ ]*")){

                if (nUsername.equals(username) || userService.getOne(nUsername) == null){
                    if (nPassword.equals(nPasswords)){
                        User userInfo = new User(userId,nUsername,nPassword,nTele);
                        int updateResult = userService.update(userInfo);
                        if (updateResult == 1){
                            Cookie cUName = new Cookie("username",nUsername);
                            cUName.setMaxAge(60 * 60 * 24 * 7);
                            resp.addCookie(cUName);

                            session.setAttribute("username",nUsername);
                            resp.getWriter().write(url);
                        }else {
                            //修改失败
                            resp.getWriter().write("2");
                        }

                    }else {
                        //密码验证错误
                        resp.getWriter().write("3");
                    }
                }else {
                    //用户名已存在
                    resp.getWriter().write("4");
                }
            }else {
                //用户名或密码为空
                resp.getWriter().write("5");
            }

        }else {
            //会话失效，跳登录页
            resp.sendRedirect("login");
        }


    }
}
