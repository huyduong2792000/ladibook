package com.huydq.ladibook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
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
	User findOneByEmail(String email);
}
