package web.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
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
        // 从请求行里获取questionId
        String questionIdPage = req.getParameter("questionId");

        // 从域对象中，取questionId的值
        Object questionIdObj = req.getAttribute("questionId");

        if (questionIdObj != null) {
            // 如果有值，那么这一次请求，就是从选项展示修改的页面过来的请求，把通过getAttribute获取questionId的值，进行赋值
            questionId = questionIdObj.toString();
        } else {
            // 如果没有值，那么这一次请求，就是从【题目管理】点击过来的请求，通过getParameter获取questionId
            questionId = req.getParameter("questionId");
        }

        // 从域对象中，取questionItem的值
        Object questionItemObj = req.getAttribute("questionItem");

        if (questionItemObj != null) {
            // 如果有值，那么表示，这一次请求是修改请求，因为toEdit方法中，把questionItem写进了域对象中，需要在输入框显示相关questionItem的数据
            QuestionItem questionItem = (QuestionItem) questionItemObj;
            // 把对象的questionItem值写入域对象，用于页面中对于输入框展示相关questionItem的操作
            req.setAttribute("questionItem", questionItem);
        }
        // 如果没有值，那么表示，这一次请求是不是修改请求，不需要任何操作

        // 如果从请求行里获取到了questionId的值，那么这个值肯定是翻页部分传递过来的
        if (questionIdPage != null) {
            // questionId进行赋值，用于翻页操作
            questionId = questionIdPage;
        }

        PageInfo<QuestionItem> questionItems = questionItemService.findByPage(questionId, currentPage, pageSize);
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

        String questionId = null;
        // 判断更改标记是否存在
        Object isUpdate = req.getAttribute("id");
        // 如果域对象中有id的值，那么这次请求就是一次修改请求，因为toEdit方法中，对request对象写入了id值
        if (isUpdate != null) {
            String id = isUpdate.toString();
            // 把对应id的questionItem删除，页面中也会删除，显示效果就是下方表格的数据，去到了上方保存的输入框中
            questionItemService.delete(id);
            Object questionIdObj = req.getAttribute("questionId");
            // 把toEdit方法中写入的值，赋值给questionId，用于后续list方法页面的显示操作
            questionId = questionIdObj.toString();
        } else {
            // 如果域对象中没有id的值，那么这次请求就是一次保存请求
            // 进行保存请求的操作，解析request对象的数据并封装为questionItem对象
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            QuestionItem questionItem = BeanUtil.fillBean(fileItems, QuestionItem.class);
            // 遍历request中的数据，取到questionId的值
            for (FileItem fileItem : fileItems) {
                if ("questionId".equals(fileItem.getFieldName())) {
                    questionId = fileItem.getString();
                }
            }
            // 拿到questionId的值，作为外键，对questionItem对象进行保存入表的操作
            questionItemService.save(questionItem);
        }
        // 把questionId的值回写到域对象，用于list方法对于页面的显示操作
        req.setAttribute("questionId", questionId);

        list(req, resp);
    }

    private void toEdit(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String questionId = req.getParameter("questionId");
        String id = req.getParameter("id");
        // 根据页面写回的id，找到对应的questionItem对象
        QuestionItem questionItem = questionItemService.findById(id);
        // 根据页面写回的questionId，再写入域对象，确保后续操作中显示的页面，仍为对应的题目
        req.setAttribute("questionId", questionId);
        // 把questionItem对象写入域对象，确保修改时，输入框中的数据，与所点击的选项的数据一致
        req.setAttribute("questionItem", questionItem);
        // 将更改标记写入域对象，更改标记就是选项的Id
        req.setAttribute("id", id);
        // 跳转到save方法，进行修改的后续操作
        save(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String questionId = req.getParameter("questionId");
        String id = req.getParameter("id");
        questionItemService.delete(id);
        req.setAttribute("questionId", questionId);
        list(req, resp);
    }
}
