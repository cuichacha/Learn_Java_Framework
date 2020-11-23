package dao;

import domain.Question;

import java.util.List;

public interface QuestionDao {
    public abstract List<Question> findAll();

    public abstract Question findById(String id);

    public abstract Integer save(Question question);

    public abstract Integer update(Question question);

    public abstract Integer delete(String id);
}
