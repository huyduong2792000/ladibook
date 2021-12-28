package com.huydq.ladibook.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.huydq.ladibook.entity.Product;
import com.huydq.ladibook.entity.ProductType;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
	Page<Product> findAllByProductType(ProductType productType, Pageable pageable);

	long countByProductType(ProductType productType);
}
