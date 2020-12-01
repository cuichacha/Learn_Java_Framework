package web.controller;

import com.github.pagehelper.PageInfo;
import code1.domain.Module;
import code1.service.ModuleService;
import code1.service.ModuleServiceImpl;
import utils.BeanUtil;
import utils.ParseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/system/module")
public class ModuleController extends HttpServlet {
    private ModuleService moduleService = new ModuleServiceImpl();

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
        PageInfo<Module> pageInfo = moduleService.findByPage(currentPage, pageSize);
        req.setAttribute("page", pageInfo);
        req.getRequestDispatcher("/WEB-INF/module/list.jsp").forward(req,resp);
    }


    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Module> moduleList = moduleService.findAll();
        req.setAttribute("moduleList", moduleList);
        req.getRequestDispatcher("/WEB-INF/module/add.jsp").forward(req,resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Module module = BeanUtil.fillBean(req, Module.class);
        moduleService.save(module);
        list(req, resp);
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Module module = moduleService.findById(id);
        req.setAttribute("module", module);
        List<Module> moduleList = moduleService.findAll();
        req.setAttribute("moduleList", moduleList);
        req.getRequestDispatcher("/WEB-INF/module/update.jsp").forward(req,resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Module module = BeanUtil.fillBean(req, Module.class);
        moduleService.update(module);
        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        moduleService.delete(id);
        list(req, resp);
    }
}
