package dao;

import domain.Catalog;

import java.util.List;

public interface CatalogDao {
    public abstract List<Catalog> findAll();

    public abstract Catalog findById(String id);

    public abstract Integer save(Catalog catalog);

    public abstract Integer update(Catalog catalog);

    public abstract Integer delete(String id);
}
