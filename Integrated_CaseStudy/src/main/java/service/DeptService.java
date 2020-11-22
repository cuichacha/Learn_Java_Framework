package service;

import com.github.pagehelper.PageInfo;
import domain.Dept;

import java.util.List;

public interface DeptService {
    public abstract PageInfo<Dept> findByPage(Integer currentPage, Integer pageSize);

    public abstract List<Dept> findAll();

    public abstract Dept findById(String id);

    public abstract Integer save(Dept dept);

    public abstract Integer update(Dept dept);

    public abstract Integer delete(String id);
}
