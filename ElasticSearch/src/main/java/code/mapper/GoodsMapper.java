package code.mapper;

import code.domain.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    public abstract List<Goods> findAll();
}
