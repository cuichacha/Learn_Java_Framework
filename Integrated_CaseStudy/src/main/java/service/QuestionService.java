package service;

import com.github.pagehelper.PageInfo;
import domain.Question;

import javax.servlet.ServletOutputStream;
import java.util.List;

public interface QuestionService {
    public abstract PageInfo<Question> findByPage(Integer currentPage, Integer pageSize);

    public abstract List<Question> findAll();

    public abstract Question findById(String id);

    public abstract Integer save(Question question);

    public abstract Integer update(Question question);

    public abstract Integer delete(String id);

    public abstract void downloadReport(ServletOutputStream servletOutputStream, String templatePath);
}
