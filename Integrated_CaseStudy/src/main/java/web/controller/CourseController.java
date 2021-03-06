package web.controller;

import com.github.pagehelper.PageInfo;
import code1.domain.Course;
import code1.service.CourseServiceImpl;
import code1.service.CourseService;
import utils.BeanUtil;
import utils.ParseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/store/course")
public class CourseController extends HttpServlet {
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

        PageInfo<Course> pageInfo = courseService.findByPage(currentPage, pageSize);
        req.setAttribute("page", pageInfo);
        req.getRequestDispatcher("/WEB-INF/course/list.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/course/add.jsp").forward(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Course course = BeanUtil.fillBean(req, Course.class);
        courseService.save(course);
        list(req, resp);
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Course course = courseService.findById(id);
        req.setAttribute("course", course);
        req.getRequestDispatcher("/WEB-INF/course/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Course course = BeanUtil.fillBean(req, Course.class);
        courseService.update(course);
        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        courseService.delete(id);
        list(req, resp);
    }
}
