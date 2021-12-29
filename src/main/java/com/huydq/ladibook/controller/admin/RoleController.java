package com.huydq.ladibook.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huydq.ladibook.entity.Role;
import com.huydq.ladibook.repositories.ProductTypeRepository;
import com.huydq.ladibook.repositories.RoleRepository;

@Controller
@RequestMapping(value = "/admin/role")
public class RoleController extends BaseController<Role, Long> {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	ProductTypeRepository productTypeRepository;

	@Autowired
	public RoleController(RoleRepository repository) {
		super(repository);
		super.setViewFolder("admin/role");
		super.setApiName("role");
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "init-role", method = RequestMethod.GET)
	public @ResponseBody String createProductType(HttpServletRequest request) {
		Role roleAdmin = roleRepository.findOneByRoleName("admin");
		if (roleAdmin == null) {
			Role newRoleAdmin = new Role();
			newRoleAdmin.setRoleName("admin");
			roleRepository.save(newRoleAdmin);
		}
		Role roleEmployee = roleRepository.findOneByRoleName("employee");
		if (roleEmployee == null) {
			Role newRoleEmployee = new Role();
			newRoleEmployee.setRoleName("employee");
			roleRepository.save(newRoleEmployee);
		}
		return "OK";
	}


}
