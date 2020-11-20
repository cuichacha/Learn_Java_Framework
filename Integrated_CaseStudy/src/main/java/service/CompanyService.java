package service;

import com.github.pagehelper.PageInfo;
import domain.Company;

public interface CompanyService {
    public abstract PageInfo<Company> findByPage(Integer currentPage, Integer pageSize);

    public abstract Company findById(String id);

    public abstract Integer add(Company company);

    public abstract Integer update(Company company);

    public abstract Integer delete(String id);
}
