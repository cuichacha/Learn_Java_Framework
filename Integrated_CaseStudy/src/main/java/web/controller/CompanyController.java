package web.controller;

import com.github.pagehelper.PageInfo;
import domain.Company;
import service.CompanyService;
import service.CompanyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/store/company")
public class CompanyController extends HttpServlet {
    private CompanyService companyService = new CompanyServiceImpl();

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

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPageStr = req.getParameter("currentPage");
        String pageSizeStr = req.getParameter("pageSize");
        Integer currentPage = Integer.parseInt(currentPageStr);
        Integer pageSize = Integer.parseInt(pageSizeStr);
        PageInfo<Company> pageInfo = companyService.findByPage(currentPage, pageSize);

    }
}
