package web.controller;

import com.github.pagehelper.PageInfo;
import code1.domain.Catalog;
import code1.domain.Company;
import code1.domain.Question;
import code1.service.*;
import utils.FileBeanUtil;
import utils.FileUtil;
import utils.ParseUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/store/question")
public class QuestionController extends HttpServlet {
    private QuestionService questionService = new QuestionServiceImpl();
    private CompanyService companyService = new CompanyServiceImpl();
    private CatalogService catalogService = new CatalogServiceImpl();

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

        PageInfo<Question> pageInfo = questionService.findByPage(currentPage, pageSize);
        req.setAttribute("page", pageInfo);
        req.getRequestDispatcher("/WEB-INF/question/list.jsp").forward(req, resp);
    }

    private void toAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> companies = companyService.findAll();
        req.setAttribute("companyList", companies);
        List<Catalog> catalogs = catalogService.findAll();
        req.setAttribute("catalogList", catalogs);
        req.getRequestDispatcher("/WEB-INF/question/add.jsp").forward(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String fileNameWithPath = FileUtil.getFileNameWithPath();
        Question question = FileBeanUtil.fillBean(req, Question.class,"upload", fileNameWithPath);
        question.setPicture(fileNameWithPath);
        questionService.save(question);
        list(req, resp);
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Question question = questionService.findById(id);
        req.setAttribute("question", question);
        List<Company> companies = companyService.findAll();
        req.setAttribute("companyList", companies);
        List<Catalog> catalogs = catalogService.findAll();
        req.setAttribute("catalogList", catalogs);
        req.getRequestDispatcher("/WEB-INF/question/update.jsp").forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String fileNameWithPath = FileUtil.getFileNameWithPath();
        Question question = FileBeanUtil.fillBean(req, Question.class,"upload", fileNameWithPath);
        question.setPicture(fileNameWithPath);
        questionService.update(question);
        list(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        questionService.delete(id);
        list(req, resp);
    }

    private void toExport(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".xlsx";

        ServletContext servletContext = req.getServletContext();
        String mimeType = servletContext.getMimeType(fileName);
        resp.setHeader("content-type", mimeType);
        // 如果需要解决文件中文名乱码问题，需要使用encoding编码解决
        resp.setHeader("content-disposition", "attachment;filename=" + fileName);

        String realPath = servletContext.getRealPath("/template/question_template.xlsx");

        questionService.downloadReport(resp.getOutputStream(), realPath);

    }
}
