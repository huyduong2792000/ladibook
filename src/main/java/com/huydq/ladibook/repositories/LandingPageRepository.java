package com.huydq.ladibook.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.huydq.ladibook.entity.LandingPage;

@Repository
public interface LandingPageRepository extends PagingAndSortingRepository<LandingPage, Long> {

	LandingPage findOneById(long id);

	LandingPage findOneByDomain(String domain);

	Page<LandingPage> findAllByStatus(String status, Pageable pageable);

	long count();

//	Page<LandingPage> findAllByProductType(ProductType productType, Pageable pageable);
//
//	long countByProductType(ProductType productType);
}
