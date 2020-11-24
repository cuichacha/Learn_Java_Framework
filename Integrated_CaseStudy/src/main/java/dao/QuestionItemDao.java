package dao;

import domain.QuestionItem;

import java.util.List;

public interface QuestionItemDao {
    public abstract List<QuestionItem> findAll(String questionId);

    public abstract QuestionItem findById(String id);

    public abstract Integer save(QuestionItem questionItem);

    public abstract Integer delete(String id);
}
