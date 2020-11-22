package web.controller;

import com.github.pagehelper.PageInfo;
import domain.Company;
import domain.Dept;
import service.DeptService;
import service.DeptServiceImpl;
import utils.BeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

@WebServlet("/system/dept")
public class DeptController extends HttpServlet {
    private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String operation = req.getParameter("operation");

        try {
            Method declaredMethod = this.getClass().getDeclaredMethod(operation, HttpServletRequest.class, HttpServletResponse.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer currentPage = 1;
        String currentPageStr = req.getParameter("page");
        if (currentPageStr != null) {
            currentPage = Integer.parseInt(currentPageStr);
        }

        Integer pageSize = 5;
        PageInfo<Dept> pageInfo = deptService.findByPage(currentPage, pageSize);
        req.setAttribute("page", pageInfo);
        req.getRequestDispatcher("/WEB-INF/dept/list.jsp").forward(req,resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> deptList = deptService.findAll();
        req.setAttribute("deptList", deptList);
        req.getRequestDispatcher("/WEB-INF/dept/add.jsp").forward(req,resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dept dept = BeanUtil.fillBean(req, Dept.class);
        dept.setId(UUID.randomUUID().toString());
        deptService.save(dept);
        list(req, resp);
    }
}
