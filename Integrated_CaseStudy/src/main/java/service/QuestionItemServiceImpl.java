package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.QuestionItemDao;
import domain.QuestionItem;
import utils.MapperUtil;

import java.util.List;
import java.util.UUID;

public class QuestionItemServiceImpl implements QuestionItemService {

    @Override
    public PageInfo<QuestionItem> findByPage(String questionId, Integer currentPage, Integer pageSize) {
        QuestionItemDao mapper = MapperUtil.getMapper(QuestionItemDao.class, true);
        PageHelper.startPage(currentPage, pageSize);
        List<QuestionItem> questionItems = mapper.findAll(questionId);
        PageInfo<QuestionItem> pageInfo = new PageInfo<>(questionItems);
        MapperUtil.close();
        return pageInfo;
    }

    @Override
    public QuestionItem findById(String id) {
        QuestionItemDao mapper = MapperUtil.getMapper(QuestionItemDao.class, true);
        QuestionItem questionItem = mapper.findById(id);
        MapperUtil.close();
        return questionItem;
    }

    @Override
    public Integer save(QuestionItem questionItem) {
        QuestionItemDao mapper = MapperUtil.getMapper(QuestionItemDao.class, true);
        questionItem.setId(UUID.randomUUID().toString());
        Integer result = mapper.save(questionItem);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer delete(String id) {
        QuestionItemDao mapper = MapperUtil.getMapper(QuestionItemDao.class, true);
        Integer result = mapper.delete(id);
        MapperUtil.close();
        return result;
    }


}
