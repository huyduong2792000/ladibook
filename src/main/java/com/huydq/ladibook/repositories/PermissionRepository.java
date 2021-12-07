package com.huydq.ladibook.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.huydq.ladibook.entity.Permission;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission, Long> {

	Permission findOneByPermissionNo(String permissionNo);
}
