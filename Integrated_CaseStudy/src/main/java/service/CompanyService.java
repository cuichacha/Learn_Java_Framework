package service;

import com.github.pagehelper.PageInfo;
import domain.Company;

public interface CompanyService {
    public abstract PageInfo<Company> findByPage(Integer currentPage, Integer pageSize);
}
