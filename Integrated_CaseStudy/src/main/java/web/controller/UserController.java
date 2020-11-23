package web.controller;

import com.github.pagehelper.PageInfo;
import domain.Dept;
import domain.User;
import service.DeptService;
import service.DeptServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import utils.BeanUtil;
import utils.MD5Util;
import utils.ParseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

@WebServlet("/system/user")
public class UserController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ParseUtil.parse(req, resp, this);
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//        String operation = req.getParameter("operation");
//        if ("list".equals(operation)) {
//            this.list(req, resp);
//        } else if ("toAdd".equals(operation)) {
//            this.toAdd(req, resp);
//        } else if ("save".equals(operation)) {
//            this.save(req, resp);
//        }

//        try {
//            Method declaredMethod = this.getClass().getDeclaredMethod(operation, HttpServletRequest.class, HttpServletResponse.class);
//            declaredMethod.setAccessible(true);
//            System.out.println(declaredMethod.getName());
//            declaredMethod.invoke(this, req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer currentPage = 1;
        Integer pageSize = 5;

        String page = req.getParameter("page");
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }

        PageInfo<User> pageInfo = userService.findByPage(currentPage, pageSize);
        req.setAttribute("page", pageInfo);
        req.getRequestDispatcher("/WEB-INF/user/list.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeptService deptService = new DeptServiceImpl();
        List<Dept> departments = deptService.findAll();
        req.setAttribute("deptList", departments);
        req.getRequestDispatcher("/WEB-INF/user/add.jsp").forward(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = BeanUtil.fillBean(req, User.class, "yyyy-MM-dd");
        user.setId(UUID.randomUUID().toString());
        userService.save(user);
        list(req, resp);
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = userService.findById(id);
        user.setPassword(MD5Util.md5(user.getPassword()));
        req.setAttribute("user", user);
        DeptService deptService = new DeptServiceImpl();
        List<Dept> departments = deptService.findAll();
        req.setAttribute("deptList", departments);
        req.getRequestDispatcher("/WEB-INF/user/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = BeanUtil.fillBean(req, User.class, "yyyy-MM-dd");
        userService.update(user);
        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        userService.delete(id);
        list(req, resp);
    }
}
