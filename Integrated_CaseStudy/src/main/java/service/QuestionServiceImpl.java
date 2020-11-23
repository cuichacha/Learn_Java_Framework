package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.QuestionDao;
import domain.Question;
import utils.MapperUtil;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class QuestionServiceImpl implements QuestionService {
    @Override
    public PageInfo<Question> findByPage(Integer currentPage, Integer pageSize) {
        QuestionDao mapper = MapperUtil.getMapper(QuestionDao.class, true);
        PageHelper.startPage(currentPage, pageSize);
        List<Question> questions = mapper.findAll();
        PageInfo<Question> pageInfo = new PageInfo<>(questions);
        return pageInfo;
    }

    @Override
    public List<Question> findAll() {
        QuestionDao mapper = MapperUtil.getMapper(QuestionDao.class, true);
        List<Question> questions = mapper.findAll();
        MapperUtil.close();
        return questions;
    }

    @Override
    public Question findById(String id) {
        QuestionDao mapper = MapperUtil.getMapper(QuestionDao.class, true);
        Question question = mapper.findById(id);
        MapperUtil.close();
        return question;
    }

    @Override
    public Integer save(Question question) {
        QuestionDao mapper = MapperUtil.getMapper(QuestionDao.class, true);
        question.setId(UUID.randomUUID().toString());
        question.setCreateTime(new Date());
        Integer result = mapper.save(question);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer update(Question question) {
        QuestionDao mapper = MapperUtil.getMapper(QuestionDao.class, true);
        Integer result = mapper.update(question);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer delete(String id) {
        QuestionDao mapper = MapperUtil.getMapper(QuestionDao.class, true);
        Integer result = mapper.delete(id);
        MapperUtil.close();
        return result;
    }
}
