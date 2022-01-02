package com.huydq.ladibook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.huydq.ladibook.entity.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {

//	List<RoleDTO> findAll();
	Role findOneByRoleName(String roleName);

	Role findOneById(Long id);

	List<Role> findByRoleName(String roleName);

//	@Query("SELECT u FROM Permission u WHERE u.landingPage.id = :roleId")
//	List<OrderCustomer> findAllByLandingPageId(@Param("roleId") Long landingpageId);
}
