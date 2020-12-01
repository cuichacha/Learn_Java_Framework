package code1.service;

import com.github.pagehelper.PageInfo;
import code1.domain.QuestionItem;


public interface QuestionItemService {
    public abstract PageInfo<QuestionItem> findByPage(String questionId, Integer currentPage, Integer pageSize);

    public abstract QuestionItem findById(String id);

    public abstract Integer save(QuestionItem questionItem);

    public abstract Integer delete(String id);
}
