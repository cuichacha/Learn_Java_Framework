package web.controller;

import com.github.pagehelper.PageInfo;
import domain.Company;
import domain.Question;
import domain.QuestionItem;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import service.QuestionItemService;
import service.QuestionItemServiceImpl;
import utils.BeanUtil;
import utils.FileBeanUtil;
import utils.FileUtil;
import utils.ParseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

//@MultipartConfig
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

        String questionId = null;
        Object questionIdObj = req.getAttribute("questionId");
        if (questionIdObj != null) {
            questionId= questionIdObj.toString();
        } else {
            questionId = req.getParameter("questionId");
        }

        PageInfo<QuestionItem> questionItems = questionItemService.findByPage(questionId, 1, 100);
        req.setAttribute("questionId", questionId);
        req.setAttribute("page", questionItems);
        req.getRequestDispatcher("/WEB-INF/questionItem/list.jsp").forward(req, resp);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String fileNameWithPath = FileUtil.getFileNameWithPath();
//        QuestionItem questionItem = FileBeanUtil.fillBean(req, QuestionItem.class, "upload", fileNameWithPath);
//        Part questionIdPart = req.getPart("questionId");
//        InputStream inputStream = questionIdPart.getInputStream();
//        String questionId = IOUtils.toString(inputStream);
//        System.out.println(questionId);
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
        List<FileItem> fileItems = servletFileUpload.parseRequest(req);
        QuestionItem questionItem = BeanUtil.fillBean(fileItems, QuestionItem.class);

        questionItemService.save(questionItem);

        String questionId = null;
        for (FileItem fileItem : fileItems) {
            if ("questionId".equals(fileItem.getFieldName())) {
                questionId = fileItem.getString();
            }
        }

        req.setAttribute("questionId", questionId);
        list(req, resp);
    }
}
