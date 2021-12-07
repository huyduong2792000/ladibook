package com.huydq.ladibook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.huydq.ladibook.entity.User;
import com.huydq.ladibook.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
		User user = userRepository.findOneByEmail(account);
		if (user == null) {
			throw new UsernameNotFoundException("Not Found!");
		}

		List<SimpleGrantedAuthority> roleList = new ArrayList<>();

		roleList.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));

		CustomUserDetails userPrincipal = new CustomUserDetails(user.getEmail(), user.getPhone(), user.getPassword(),
				roleList);
		userPrincipal.setUserId(user.getUserId());
		userPrincipal.setEmail(user.getEmail());
		userPrincipal.setPhone(user.getPhone());
		userPrincipal.setAddress(user.getAddress());
		userPrincipal.setAvatar(user.getAvatar());
		userPrincipal.setFullname(user.getFullname());
		userPrincipal.setVerify(user.isVerify());
		userPrincipal.setGender(user.getGender());
		userPrincipal.setPassword(user.getPassword());
		userPrincipal.setRole(user.getRole());
		return userPrincipal;
	}
//	@Autowired
//	private UserDao userDao;
//
//	@Override
//	public void insert(UserDTO userDTO) {
//		Role role = new Role();
//		role.setRoleId(userDTO.getRoleDTO().getRoleId());
//
//		User user = new User();
//		user.setUserId(userDTO.getUserId());
//		user.setEmail(userDTO.getEmail());
//		user.setPhone(userDTO.getPhone());
//		user.setAddress(userDTO.getAddress());
//		user.setAvatar(userDTO.getAvatar());
//		user.setFullname(userDTO.getFullname());
//		user.setVerify(userDTO.isVerify());
//		user.setGender(userDTO.isGender());
//		user.setPassword(userDTO.getPassword());
//		user.setRole(role);
//
//		userDao.insert(user);
//	}
//
//	@Override
//	public void update(UserDTO userDTO) {
//		Role role = new Role();
//		role.setRoleId(userDTO.getRoleDTO().getRoleId());
//
//		User user = new User();
//		user.setUserId(userDTO.getUserId());
//		user.setEmail(userDTO.getEmail());
//		user.setPhone(userDTO.getPhone());
//		user.setAddress(userDTO.getAddress());
//		user.setAvatar(userDTO.getAvatar());
//		user.setFullname(userDTO.getFullname());
//		user.setVerify(userDTO.isVerify());
//		user.setGender(userDTO.isGender());
//		user.setPassword(userDTO.getPassword());
//		user.setRole(role);
//
//		userDao.update(user);
//	}
//
//	@Override
//	public void delete(long userId) {
//		// TODO Auto-generated method stub
//		userDao.delete(userId);
//	}
//
//	@Override
//	public UserDTO findById(long userId) {
//		User user = userDao.findById(userId);
//		RoleDTO roleDTO = new RoleDTO();
//		roleDTO.setRoleId(user.getRole().getRoleId());
//		roleDTO.setRoleName(user.getRole().getRoleName());
//
//		UserDTO userDTO = new UserDTO();
//		userDTO.setUserId(user.getUserId());
//		userDTO.setEmail(user.getEmail());
//		userDTO.setPhone(user.getPhone());
//		userDTO.setAddress(user.getAddress());
//		userDTO.setAvatar(user.getAvatar());
//		userDTO.setFullname(user.getFullname());
//		userDTO.setVerify(user.isVerify());
//		userDTO.setGender(user.isGender());
//		userDTO.setPassword(user.getPassword());
//		userDTO.setRoleDTO(roleDTO);
//		return userDTO;
//	}
//
//	@Override
//	public List<UserDTO> findAll(int pageIndex, int PageSize) {
//		List<User> users = userDao.findAll(pageIndex, PageSize);
//		List<UserDTO> userDTOs = new ArrayList<>();
//		for (User user : users) {
//			RoleDTO roleDTO = new RoleDTO();
//			roleDTO.setRoleId(user.getRole().getRoleId());
//			roleDTO.setRoleName(user.getRole().getRoleName());
//
//			UserDTO userDTO = new UserDTO();
//			userDTO.setUserId(user.getUserId());
//			userDTO.setEmail(user.getEmail());
//			userDTO.setPhone(user.getPhone());
//			userDTO.setAddress(user.getAddress());
//			userDTO.setAvatar(user.getAvatar());
//			userDTO.setFullname(user.getFullname());
//			userDTO.setVerify(user.isVerify());
//			userDTO.setGender(user.isGender());
//			userDTO.setPassword(user.getPassword());
//			userDTO.setRoleDTO(roleDTO);
//
//			userDTOs.add(userDTO);
//		}
//		return userDTOs;
//	}
//
//	@Override
//	public UserDTO findByEmailOrPhoneAndPassword(String account, String password, boolean verity) {
//		User user = userDao.findByEmailOrPhoneAndPassword(account, password, verity);
//		RoleDTO roleDTO = new RoleDTO();
//		roleDTO.setRoleId(user.getRole().getRoleId());
//		roleDTO.setRoleName(user.getRole().getRoleName());
//
//		UserDTO userDTO = new UserDTO();
//		userDTO.setUserId(user.getUserId());
//		userDTO.setEmail(user.getEmail());
//		userDTO.setPhone(user.getPhone());
//		userDTO.setAddress(user.getAddress());
//		userDTO.setAvatar(user.getAvatar());
//		userDTO.setFullname(user.getFullname());
//		userDTO.setVerify(user.isVerify());
//		userDTO.setGender(user.isGender());
//		userDTO.setPassword(user.getPassword());
//		userDTO.setRoleDTO(roleDTO);
//		return userDTO;
//	}
//

//
//	@Override
//	public int count() {
//		return userDao.count();
//	}
//
//	@Override
//	public UserDTO findByEmail(String email) {
//		User user = userDao.findByEmail(email);
//		if (user != null) {
//			UserDTO userDTO = new UserDTO();
//			RoleDTO roleDTO = new RoleDTO();
//			roleDTO.setRoleId(user.getRole().getRoleId());
//			roleDTO.setRoleName(user.getRole().getRoleName());
//
//			userDTO.setUserId(user.getUserId());
//			userDTO.setEmail(user.getEmail());
//			userDTO.setPhone(user.getPhone());
//			userDTO.setAddress(user.getAddress());
//			userDTO.setAvatar(user.getAvatar());
//			userDTO.setFullname(user.getFullname());
//			userDTO.setVerify(user.isVerify());
//			userDTO.setGender(user.isGender());
//			userDTO.setPassword(user.getPassword());
//			userDTO.setRoleDTO(roleDTO);
//			return userDTO;
//		}
//		return null;
//	}
}