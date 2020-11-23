package web.controller;

import com.github.pagehelper.PageInfo;
import domain.Company;
import service.CompanyService;
import service.CompanyServiceImpl;
import utils.BeanUtil;
import utils.ParseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;

@WebServlet("/store/company")
public class CompanyController extends HttpServlet {
    private CompanyService companyService = new CompanyServiceImpl();
//    private CompanyController companyController = new CompanyController();

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
//        String currentPageStr = req.getParameter("pageNum");
//        String pageSizeStr = req.getParameter("pageSize");
//        Integer currentPage = Integer.parseInt(currentPageStr);
//        Integer pageSize = Integer.parseInt(pageSizeStr);
        Integer currentPage = 1;
        String currentPageStr = req.getParameter("page");
        if (currentPageStr != null) {
            currentPage = Integer.parseInt(currentPageStr);
        }

        Integer pageSize = 5;
        PageInfo<Company> pageInfo = companyService.findByPage(currentPage, pageSize);
        req.setAttribute("page", pageInfo);
        req.getRequestDispatcher("/WEB-INF/company/list.jsp").forward(req,resp);
    }

//    private Company findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String idStr = req.getParameter("id");
//        Integer id = Integer.parseInt(idStr);
//        Company company = companyService.findById(id);
//        return company;
//    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/company/add.jsp").forward(req,resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Company company = BeanUtil.fillBean(req, Company.class, "yyyy-MM-dd");
        companyService.add(company);
        list(req, resp);
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
//        Integer id = Integer.parseInt(idStr);
        Company company = companyService.findById(id);
        req.setAttribute("company", company);
        req.getRequestDispatcher("/WEB-INF/company/update.jsp").forward(req,resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Company company = BeanUtil.fillBean(req, Company.class, "yyyy-MM-dd");
        companyService.update(company);
        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
//        Company company = companyService.findById(id);
        Integer result = companyService.delete(id);
        list(req, resp);

    }
}
