package com.huydq.ladibook.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.huydq.ladibook.entity.OrderCustomer;

@Repository
public interface OrderCustomerRepository extends PagingAndSortingRepository<OrderCustomer, Long> {

	OrderCustomer findOneById(long id);

	OrderCustomer findOneByEmail(String email);

	Page<OrderCustomer> findAll(Pageable pageable);

	Page<OrderCustomer> findAllByStatus(String status, Pageable pageable);

	@Query("SELECT u FROM OrderCustomer u WHERE u.landingPage.id = :landingpageId")
	Page<OrderCustomer> findAllByLandingPageId(@Param("landingpageId") Long landingpageId, Pageable pageable);

	@Query("SELECT u FROM OrderCustomer u WHERE u.customer.id = :customerId")
	Page<OrderCustomer> findAllByCustomerId(@Param("customerId") Long customerId, Pageable pageable);

	@Query("SELECT u FROM OrderCustomer u WHERE u.employee.id = :employeeId")
	Page<OrderCustomer> findAllByEmployeeId(@Param("employeeId") Long employeeId, Pageable pageable);

	long count();

	@Query("SELECT SUM(m.viewCount) FROM LandingPage m")
	long sumViewCount();

	@Query("SELECT SUM(m.orderCount) FROM LandingPage m")
	long sumOrderCount();
//	Page<LandingPage> findAllByProductType(ProductType productType, Pageable pageable);
//
//	long countByProductType(ProductType productType);
}
