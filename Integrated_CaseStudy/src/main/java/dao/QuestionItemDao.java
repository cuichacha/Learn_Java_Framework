package dao;

import domain.QuestionItem;

import java.util.List;

public interface QuestionItemDao {
    public abstract List<QuestionItem> findAll(String questionId);
}
