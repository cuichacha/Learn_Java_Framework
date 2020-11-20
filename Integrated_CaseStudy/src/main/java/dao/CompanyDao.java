package dao;

import domain.Company;

import java.util.List;

public interface CompanyDao {
    public abstract List<Company> findAll();
}
