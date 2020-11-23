package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.CatalogDao;
import domain.Catalog;
import utils.MapperUtil;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CatalogServiceImpl implements CatalogService {
    @Override
    public PageInfo<Catalog> findByPage(Integer currentPage, Integer pageSize) {
        CatalogDao mapper = MapperUtil.getMapper(CatalogDao.class, true);
        PageHelper.startPage(currentPage, pageSize);
        List<Catalog> catalogs = mapper.findAll();
        PageInfo<Catalog> pageInfo = new PageInfo<>(catalogs);
        return pageInfo;
    }

    @Override
    public List<Catalog> findAll() {
        CatalogDao mapper = MapperUtil.getMapper(CatalogDao.class, true);
        List<Catalog> catalogs = mapper.findAll();
        MapperUtil.close();
        return catalogs;
    }

    @Override
    public Catalog findById(String id) {
        CatalogDao mapper = MapperUtil.getMapper(CatalogDao.class, true);
        Catalog catalog = mapper.findById(id);
        MapperUtil.close();
        return catalog;
    }

    @Override
    public Integer save(Catalog catalog) {
        CatalogDao mapper = MapperUtil.getMapper(CatalogDao.class, true);
        catalog.setId(UUID.randomUUID().toString());
        catalog.setCreateTime(new Date());
        Integer result = mapper.save(catalog);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer update(Catalog catalog) {
        CatalogDao mapper = MapperUtil.getMapper(CatalogDao.class, true);
        Integer result = mapper.update(catalog);
        MapperUtil.close();
        return result;
    }

    @Override
    public Integer delete(String id) {
        CatalogDao mapper = MapperUtil.getMapper(CatalogDao.class, true);
        Integer result = mapper.delete(id);
        MapperUtil.close();
        return result;
    }
}
