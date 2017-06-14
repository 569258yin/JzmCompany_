package com.jinzhimu.company.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jinzhimu.company.model.News;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface NewsRepository extends CrudRepository<News, Long>{

	Page<News> findAll(Pageable pageable);

	News findById(long id);
}
