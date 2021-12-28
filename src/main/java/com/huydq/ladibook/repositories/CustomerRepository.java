package com.huydq.ladibook.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.huydq.ladibook.entity.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

	Customer findOneById(long id);

	Customer findOneByEmail(String email);

	long count();
//	Page<LandingPage> findAllByProductType(ProductType productType, Pageable pageable);
//
//	long countByProductType(ProductType productType);
}
