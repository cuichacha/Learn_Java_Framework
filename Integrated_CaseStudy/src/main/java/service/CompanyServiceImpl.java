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
        MapperUtil.close();
        return pageInfo;
    }

    @Override
    public Company findById(String id) {
        CompanyDao mapper = MapperUtil.getMapper(CompanyDao.class, true);
        Company company = mapper.findById(id);
        MapperUtil.close();
        return company;
    }

    @Override
    public Integer add(Company company) {
        CompanyDao mapper = MapperUtil.getMapper(CompanyDao.class, true);
        Integer result = mapper.save(company);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer update(Company company) {
        CompanyDao mapper = MapperUtil.getMapper(CompanyDao.class, true);
        Integer result = mapper.update(company);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer delete(String id) {
        CompanyDao mapper = MapperUtil.getMapper(CompanyDao.class, true);
        Integer result = mapper.delete(id);
        MapperUtil.close();
        return result;
    }
}
