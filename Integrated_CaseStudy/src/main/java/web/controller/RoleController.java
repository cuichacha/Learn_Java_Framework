package web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import domain.Module;
import domain.Role;
import domain.RoleModule;
import service.ModuleService;
import service.ModuleServiceImpl;
import service.RoleService;
import service.RoleServiceImpl;
import utils.BeanUtil;
import utils.ParseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/system/role")
public class RoleController extends HttpServlet {
    private RoleService roleService = new RoleServiceImpl();
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
        PageInfo<Role> pageInfo = roleService.findByPage(currentPage, pageSize);
        req.setAttribute("page", pageInfo);
        req.getRequestDispatcher("/WEB-INF/role/list.jsp").forward(req,resp);
    }


    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/role/add.jsp").forward(req,resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Role role = BeanUtil.fillBean(req, Role.class);
        roleService.save(role);
        list(req, resp);
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Role role = roleService.findById(id);
        req.setAttribute("role", role);
        req.getRequestDispatcher("/WEB-INF/role/update.jsp").forward(req,resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Role role = BeanUtil.fillBean(req, Role.class);
        roleService.update(role);
        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        roleService.delete(id);
        list(req, resp);
    }

    private void authorize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleId = req.getParameter("id");
        List<RoleModule> roleModules = moduleService.findModuleByRoleId(roleId);
        ObjectMapper objectMapper = new ObjectMapper();
        String roleModulesJson = objectMapper.writeValueAsString(roleModules);
        req.setAttribute("roleModulesJson", roleModulesJson);
        req.setAttribute("roleId", roleId);
        req.getRequestDispatcher("/WEB-INF/role/checkbox_count_en.jsp").forward(req,resp);
    }

    private void updateRoleModules(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String roleId = req.getParameter("roleId");
        String[] moduleIds = req.getParameterValues("moduleIds");
        roleService.updateRoleModule(roleId, moduleIds);
        list(req, resp);
    }
}
