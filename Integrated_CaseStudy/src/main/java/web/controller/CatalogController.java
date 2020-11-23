package web.controller;

import com.github.pagehelper.PageInfo;
import domain.Catalog;
import domain.Course;
import service.CatalogService;
import service.CatalogServiceImpl;
import service.CourseService;
import service.CourseServiceImpl;
import utils.BeanUtil;
import utils.ParseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/store/catalog")
public class CatalogController extends HttpServlet {
    private CatalogService catalogService = new CatalogServiceImpl();
    private CourseService courseService = new CourseServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ParseUtil.parse(req, resp, this);
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

        PageInfo<Catalog> pageInfo = catalogService.findByPage(currentPage, pageSize);
        req.setAttribute("page", pageInfo);
        req.getRequestDispatcher("/WEB-INF/catalog/list.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courses = courseService.findAll();
        req.setAttribute("courseList", courses);
        req.getRequestDispatcher("/WEB-INF/catalog/add.jsp").forward(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Catalog catalog = BeanUtil.fillBean(req, Catalog.class, "yyyy-MM-dd");
        catalogService.save(catalog);
        list(req, resp);
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Catalog catalog = catalogService.findById(id);
        req.setAttribute("catalog", catalog);
        List<Course> courses = courseService.findAll();
        req.setAttribute("courseList", courses);
        req.getRequestDispatcher("/WEB-INF/catalog/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Catalog catalog = BeanUtil.fillBean(req, Catalog.class, "yyyy-MM-dd");
        catalogService.update(catalog);
        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        catalogService.delete(id);
        list(req, resp);
    }
}
