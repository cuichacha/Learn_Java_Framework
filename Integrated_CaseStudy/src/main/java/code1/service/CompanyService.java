package code1.service;

import com.github.pagehelper.PageInfo;
import code1.domain.Company;

import java.util.List;

public interface CompanyService {
    public abstract PageInfo<Company> findByPage(Integer currentPage, Integer pageSize);

    public abstract List<Company> findAll();

    public abstract Company findById(String id);

    public abstract Integer add(Company company);

    public abstract Integer update(Company company);

    public abstract Integer delete(String id);
}
