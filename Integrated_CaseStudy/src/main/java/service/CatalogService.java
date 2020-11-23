package service;

import com.github.pagehelper.PageInfo;
import domain.Catalog;

public interface CatalogService {
    public abstract PageInfo<Catalog> findByPage(Integer currentPage, Integer pageSize);

    public abstract Catalog findById(String id);

    public abstract Integer save(Catalog catalog);

    public abstract Integer update(Catalog catalog);

    public abstract Integer delete(String id);
}
