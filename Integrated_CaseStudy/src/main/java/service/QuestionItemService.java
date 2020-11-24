package service;

import com.github.pagehelper.PageInfo;
import domain.QuestionItem;

import java.util.List;


public interface QuestionItemService {
    public abstract PageInfo<QuestionItem> findByPage(String questionId, Integer currentPage, Integer pageSize);

    public abstract QuestionItem findById(String id);

    public abstract Integer save(QuestionItem questionItem);

    public abstract Integer delete(String id);
}
