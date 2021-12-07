package com.huydq.ladibook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.huydq.ladibook.entity.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {

//	List<RoleDTO> findAll();
	Role findOneByRoleName(String roleName);

	List<Role> findByRoleName(String roleName);

	@Nullable
	Role findOneByRoleId(long roleId);

}
