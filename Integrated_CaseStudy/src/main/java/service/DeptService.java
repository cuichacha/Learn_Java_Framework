package service;

import com.github.pagehelper.PageInfo;
import domain.Dept;

import java.util.List;

public interface DeptService {
    public abstract PageInfo<Dept> findByPage();
}
