package code1.service;

import com.github.pagehelper.PageInfo;
import code1.domain.Catalog;

import java.util.List;

public interface CatalogService {
    public abstract PageInfo<Catalog> findByPage(Integer currentPage, Integer pageSize);

    public abstract List<Catalog> findAll();

    public abstract Catalog findById(String id);

    public abstract Integer save(Catalog catalog);

    public abstract Integer update(Catalog catalog);

    public abstract Integer delete(String id);
}
