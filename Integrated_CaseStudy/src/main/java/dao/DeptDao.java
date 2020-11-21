package dao;

import domain.Dept;

import java.util.List;

public interface DeptDao {
    public abstract List<Dept> findAll();
}
