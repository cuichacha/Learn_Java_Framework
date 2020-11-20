package dao;

import domain.Company;

import java.util.List;

public interface CompanyDao {
    public abstract List<Company> findAll();

    public abstract Company findById(String id);

    public abstract Integer save(Company company);

    public abstract Integer update(Company company);

    public abstract Integer delete(String id);
}
