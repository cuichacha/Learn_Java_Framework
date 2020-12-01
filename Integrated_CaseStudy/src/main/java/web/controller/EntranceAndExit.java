package web.controller;

import code1.domain.Module;
import code1.domain.User;
import code1.service.ModuleService;
import code1.service.ModuleServiceImpl;
import code1.service.UserService;
import code1.service.UserServiceImpl;
import utils.MD5Util;
import utils.ParseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EntranceAndExit")
public class EntranceAndExit extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private ModuleService moduleService = new ModuleServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ParseUtil.parse(req, resp, this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String pwd = MD5Util.md5(password);
        User user = userService.findByEmail(email);
        String id = user.getId();
        List<Module> modules = moduleService.findModuleByUserId(id);

        if (user == null) {
            req.setAttribute("wrongEmail", true);
//            resp.sendRedirect("/CaseStudy/login.jsp");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else if (!pwd.equals(user.getPassword())) {
            req.setAttribute("wrongPwd", true);
//            resp.sendRedirect("/CaseStudy/login.jsp");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            req.setAttribute("modules", modules);
            req.getSession().setAttribute("UserId", id);
            req.getSession().setAttribute("logInUser", user);
            req.getRequestDispatcher("/WEB-INF/pages/home/main.jsp").forward(req, resp);
        }
    }

    private void goHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/home/home.jsp").forward(req, resp);
    }

    private void logOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        resp.sendRedirect("/CaseStudy/login.jsp");
    }
}
