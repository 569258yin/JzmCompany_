package com.jinzhimu.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jinzhimu.company.model.Goods;
@Transactional
public interface GoodsRepository extends CrudRepository<Goods, Long>{

}
