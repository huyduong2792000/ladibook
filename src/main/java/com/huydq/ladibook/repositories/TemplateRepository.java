package com.huydq.ladibook.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.huydq.ladibook.entity.Template;

@Repository
public interface TemplateRepository extends PagingAndSortingRepository<Template, Long> {

	Template findOneById(long id);

	Template findOneByTemplateNo(String templateNo);
//	Page<LandingPage> findAllByProductType(ProductType productType, Pageable pageable);
//
//	long countByProductType(ProductType productType);
}
