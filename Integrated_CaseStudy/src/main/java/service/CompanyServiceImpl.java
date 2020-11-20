package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.CompanyDao;
import domain.Company;
import utils.MapperUtil;

import java.util.List;

public class CompanyServiceImpl implements CompanyService{

    @Override
    public PageInfo<Company> findByPage(Integer currentPage, Integer pageSize) {
        CompanyDao mapper = MapperUtil.getMapper(CompanyDao.class, true);
        PageHelper.startPage(currentPage, pageSize);
        List<Company> companies = mapper.findAll();
        PageInfo<Company> pageInfo = new PageInfo<>(companies);
        return pageInfo;
    }
}
