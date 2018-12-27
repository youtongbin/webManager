package com.neuedu.controller;

import com.neuedu.dao.*;
import com.neuedu.pojo.*;
import com.neuedu.service.*;
import myTools.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    IUserService userService = new UserService();
    IUserRoleService userRoleService = new UserRoleService();
    IRoleFunctionService roleFunctionService = new RoleFunctionService();
    IFunctionService functionService = new FunctionService();
    IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //通过cookie获取上次登录的用户名
        Cookie[] cookies = req.getCookies();
        Map<String,Cookie> map = CookieUtil.getCookie(cookies);
        Cookie cUName = map.get("username");
        String username = cUName.getValue();
        System.out.println("CookieInfo:username="+username);

        req.setAttribute("username",username);

        req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (!username.matches("[ ]*") && !password.matches("[ ]*")){
            User user = userService.getOne(username);
            if (user != null){
                if (password.equals(user.getPassword())){
                    /**
                     * 登录验证成功
                     * 通过用户id获取该用户充当角色信息（role_id）
                     * 通过role_id获取其最高权限对应跳转地址（function_id）
                     * 跳转url
                     */

                    /**
                     * 个人信息
                     */
                    List<UserRole> userRoles = userRoleService.getLists(user.getId());
                    Integer maxRoleId = userRoles.get(0).getRoleId();
                    List<RoleFunction> roleFunctions = roleFunctionService.getLists(maxRoleId);
                    Integer maxFunctionId = roleFunctions.get(0).getFunctionId();
                    Function function = functionService.getOne(maxFunctionId);
                    String url = function.getUrl();

                    /**
                     * cookie
                     * 创建cookie信息
                     */
                    Cookie cUName = new Cookie("username",username);
                    cUName.setMaxAge(60 * 60 * 24 * 7);
                    resp.addCookie(cUName);

                    //session设置5分钟失效
                    HttpSession session =  req.getSession();
                    session.setMaxInactiveInterval(60 * 5);
                    session.setAttribute("username",username);
                    session.setAttribute("url",url);

                    /**
                     * 用户登录检测通过，带着用户信息，转发到获取商品信息请求，获取商品信息
                     */
//                    req.setAttribute("url",url);
//                    req.getRequestDispatcher("product_list").forward(req,resp);

                    resp.getWriter().write(url);
                }else {
                    //密码错误
                    resp.getWriter().write("2");
                }
            }else {
                //没有该用户
                resp.getWriter().write("3");
            }
        }else {
            //用户名或密码输入为空
            resp.getWriter().write("4");
        }



    }
}
