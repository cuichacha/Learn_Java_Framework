package code.service;

import code.domain.Goods;

import java.util.List;

public interface GoodsService {
    public abstract List<Goods> findAll();
}
