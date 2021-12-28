package com.huydq.ladibook.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.huydq.ladibook.entity.Order;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

	Order findOneById(long id);

//	Page<LandingPage> findAllByProductType(ProductType productType, Pageable pageable);
//
//	long countByProductType(ProductType productType);
}
