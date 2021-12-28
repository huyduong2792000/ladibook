package com.huydq.ladibook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.huydq.ladibook.entity.ProductType;

@Repository
@Transactional
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
	ProductType findOneByProductTypeNo(String productTypeNo);
}
