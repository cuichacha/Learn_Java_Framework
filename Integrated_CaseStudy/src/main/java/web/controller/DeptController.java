package web.controller;

import com.github.pagehelper.PageInfo;
import code1.domain.Dept;
import code1.service.DeptService;
import code1.service.DeptServiceImpl;
import utils.BeanUtil;
import utils.ParseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/system/dept")
public class DeptController extends HttpServlet {
    private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ParseUtil.parse(req,resp,this);
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
        deptService.save(dept);
        list(req, resp);
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Dept dept = deptService.findById(id);
        req.setAttribute("dept", dept);
        List<Dept> deptList = deptService.findAll();
        req.setAttribute("deptList", deptList);
        req.getRequestDispatcher("/WEB-INF/dept/update.jsp").forward(req,resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dept dept = BeanUtil.fillBean(req, Dept.class);
        deptService.update(dept);
        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        deptService.delete(id);
        list(req, resp);
    }
}
