package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.QuestionItemDao;
import domain.QuestionItem;
import utils.MapperUtil;

import java.util.List;

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


}
