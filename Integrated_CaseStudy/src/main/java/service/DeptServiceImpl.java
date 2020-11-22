package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.DeptDao;
import domain.Dept;
import utils.MapperUtil;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    @Override
    public PageInfo<Dept> findByPage(Integer currentPage, Integer pageSize) {
        DeptDao mapper = MapperUtil.getMapper(DeptDao.class, true);
        PageHelper.startPage(currentPage, pageSize);
        List<Dept> departments = mapper.findAll();
        PageInfo<Dept> pageInfo = new PageInfo<>(departments);
        MapperUtil.close();
        return pageInfo;
    }

    @Override
    public List<Dept> findAll() {
        DeptDao mapper = MapperUtil.getMapper(DeptDao.class, true);
        List<Dept> departments = mapper.findAll();
        MapperUtil.close();
        return departments;
    }

    @Override
    public Dept findById(String id) {
        return null;
    }

    @Override
    public Integer save(Dept dept) {
        DeptDao mapper = MapperUtil.getMapper(DeptDao.class, true);
        Integer result = mapper.save(dept);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer update(Dept dept) {
        return null;
    }

    @Override
    public Integer delete(String id) {
        return null;
    }
}
