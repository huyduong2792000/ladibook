package com.huydq.ladibook.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.huydq.ladibook.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//	void insert(UserDTO userDTO);
//	
//	void update(UserDTO userDTO);
//	
//	void delete(long userId);
//	
//	UserDTO findById(long userId);
//	
//	List<UserDTO> findAll(int pageIndex, int PageSize);
//
//	UserDTO findByEmailOrPhoneAndPassword(String account, String password, boolean verity);
//	
//	UserDTO findByEmail(String email);
//	
//	long count();
	User findOneById(Long id);

	User findOneByEmail(String email);

	Page<User> findAll(Pageable pageable);

	@Query("SELECT u FROM User u WHERE u.role.id = :roleId")
	List<User> findAllbyRoleId(@Param("roleId") Long roleId);
}
