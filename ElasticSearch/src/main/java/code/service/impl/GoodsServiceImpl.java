package code.service.impl;

import code.domain.Goods;
import code.mapper.GoodsMapper;
import code.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> findAll() {
        List<Goods> goods = goodsMapper.findAll();
        return goods;
    }
}
