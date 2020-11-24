package web.controller;

import com.github.pagehelper.PageInfo;
import domain.Company;
import domain.QuestionItem;
import service.QuestionItemService;
import service.QuestionItemServiceImpl;
import utils.ParseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/store/questionItem")
public class QuestionItemController extends HttpServlet {
    private QuestionItemService questionItemService = new QuestionItemServiceImpl();

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

        String questionId = req.getParameter("questionId");
        PageInfo<QuestionItem> questionItems = questionItemService.findByPage(questionId, currentPage, pageSize);
        req.setAttribute("page", questionItems);
        req.getRequestDispatcher("/WEB-INF/questionItem/list.jsp").forward(req, resp);
    }
}
