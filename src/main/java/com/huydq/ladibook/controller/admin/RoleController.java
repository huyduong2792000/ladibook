package com.huydq.ladibook.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huydq.ladibook.entity.Permission;
import com.huydq.ladibook.entity.Role;
import com.huydq.ladibook.repositories.PermissionRepository;
import com.huydq.ladibook.repositories.ProductTypeRepository;
import com.huydq.ladibook.repositories.RoleRepository;
import com.huydq.ladibook.repositories.UserRepository;

@Controller
@RequestMapping(value = "/admin/role")
public class RoleController extends BaseController<Role, Long> {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	ProductTypeRepository productTypeRepository;
	@Autowired
	private PermissionRepository permissionRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	public RoleController(RoleRepository repository) {
		super(repository);
		super.setViewFolder("admin/role");
		super.setApiName("role");
		super.setListViewPermission(new String[] { "grant_permission" });
		// TODO Auto-generated constructor stub
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getSingle(HttpServletRequest request, @PathVariable Long id) {
		if (!checkPermission(new String[] { "grant_permission" })) {
			ModelAndView mav = new ModelAndView("admin/common/access_denied");
			return mav;
		}
		ModelAndView mav = new ModelAndView("admin/role/update");
		Role result = roleRepository.findById(id).get();
		List<Permission> allPermissions = permissionRepository.findAll();

		mav.addObject("result", result);
		mav.addObject("allPermissions", allPermissions);
		return mav;
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public @ResponseBody ModelAndView get(HttpServletRequest request, Model model) {
		if (!checkPermission(new String[] { "grant_permission" })) {
			ModelAndView mav = new ModelAndView("admin/common/access_denied");
			return mav;
		}
		ModelAndView mav = new ModelAndView("admin/role/create");
		Role result = new Role();
		List<Permission> allPermissions = permissionRepository.findAll();

		mav.addObject("result", result);
		mav.addObject("allPermissions", allPermissions);
		return mav;
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String CreateSingle(HttpServletRequest request, @ModelAttribute("result") Role bodyData) {
		System.out.println(bodyData);
		if (!checkPermission(new String[] { "grant_permission" })) {
			return "redirect:/ladibook/admin/access-denined";
		}
		String[] permissionIds = request.getParameterValues("permissionIds");

		String roleName = request.getParameter("roleName");
		Role roleInfo = new Role();
		roleInfo.setRoleName(roleName);
		roleInfo = roleRepository.save(roleInfo);
		if (permissionIds == null) {
			return "redirect:../role/list";
		}

		roleInfo = roleRepository.findOneById(roleInfo.getId());
		for (String permissionId : permissionIds) {
			System.out.println(permissionId);
			Permission permissionInfo = permissionRepository.findOneById(Long.valueOf(permissionId));
			roleInfo.addPermission(permissionInfo);
		}
		roleInfo = roleRepository.save(roleInfo);
		return "redirect:../role/list";
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateSigle(HttpServletRequest request, @PathVariable Long id,
			@ModelAttribute("result") Role bodyData) {
		System.out.println(bodyData);
		if (!checkPermission(new String[] { "grant_permission" })) {
			return "redirect:/ladibook/admin/access-denined";
		}
		String[] permissionIds = request.getParameterValues("permissionIds");

		String roleName = request.getParameter("roleName");
		Role roleInfo = roleRepository.findOneById(id);
		if (roleInfo.getRoleName() == "admin") {
			return "redirect:../role/list";
		}
		roleInfo.setRoleName(roleName);

		// ??o???n n??y h??i c???ng k???nh sau n??y ph???i t??m cachs d??ng populate
		roleInfo.setPermissions(null);
		roleRepository.save(roleInfo);
		if (permissionIds == null) {
			return "redirect:../role/list";
		}
		roleInfo = roleRepository.findOneById(id);
		for (String permissionId : permissionIds) {
			System.out.println(permissionId);
			Permission permissionInfo = permissionRepository.findOneById(Long.valueOf(permissionId));
			roleInfo.addPermission(permissionInfo);
		}
		roleInfo = roleRepository.save(roleInfo);
		return "redirect:../role/list";
	}
	@RequestMapping(value = "init-role", method = RequestMethod.GET)
	public @ResponseBody String createRole(HttpServletRequest request) {
		Role roleAdmin = roleRepository.findOneByRoleName("admin");
		if (roleAdmin == null) {
			roleAdmin = new Role();
		}
		roleAdmin.setRoleName("admin");
		roleAdmin = roleRepository.save(roleAdmin);

		Role roleEmployee = roleRepository.findOneByRoleName("employee");
		if (roleEmployee == null) {
			roleEmployee = new Role();
		}
		roleEmployee.setRoleName("employee");
		roleRepository.save(roleEmployee);

		if (roleAdmin.getPermissions().isEmpty()) {
			HashMap<String, String> permissionDefault = new HashMap<String, String>();
			permissionDefault.put("create_order", "T???o y??u c???u");
			permissionDefault.put("read_order", "Xem y??u c???u");
			permissionDefault.put("update_order", "S???a y??u c???u");
			permissionDefault.put("delete_order", "X??a y??u c???u");

			permissionDefault.put("all_employee", "Qu???n l?? th??ng tin nh??n vi??n");

			permissionDefault.put("read_contact", "Xem th??ng tin kh??ch h??ng");
			permissionDefault.put("update_contact", "S???a th??ng tin kh??ch h??ng");

			permissionDefault.put("create_landingpage", "T???o landingpage");
			permissionDefault.put("update_landingpage", "S???a landingpage");
			permissionDefault.put("delete_landingpage", "X??a landingpage");

			permissionDefault.put("grant_permission", "Ph??n quy???n user");

			for (Map.Entry<String, String> permission : permissionDefault.entrySet()) {
				Permission permissionInfo = permissionRepository.findOneByPermissionNo(permission.getKey());
				if (permissionInfo == null) {
					permissionInfo = permissionRepository
							.save(new Permission(permission.getKey(), permission.getValue()));
				}
				permissionInfo = permissionRepository.findOneByPermissionNo(permission.getKey());
				System.out.println(permissionInfo);
				roleAdmin.addPermission(permissionInfo);
			}

			roleRepository.save(roleAdmin);
		}
		return "OK";
	}


}
