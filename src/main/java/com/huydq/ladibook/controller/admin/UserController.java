package com.huydq.ladibook.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huydq.ladibook.entity.Role;
import com.huydq.ladibook.entity.User;
import com.huydq.ladibook.repositories.CustomerRepository;
import com.huydq.ladibook.repositories.LandingPageRepository;
import com.huydq.ladibook.repositories.OrderCustomerRepository;
import com.huydq.ladibook.repositories.OrderRepository;
import com.huydq.ladibook.repositories.RoleRepository;
import com.huydq.ladibook.repositories.UserRepository;

@Controller
@RequestMapping(value = "/admin/user")
public class UserController extends BaseController<User, Long> {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	private LandingPageRepository landingPageRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OrderCustomerRepository orderCustomerRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	public UserController(UserRepository repository) {
		super(repository);
		super.setViewFolder("admin/user");
		super.setApiName("user");
		super.setListViewPermission(new String[] { "all_employee" });
		// TODO Auto-generated constructor stub
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getSingle(HttpServletRequest request, @PathVariable Long id) {
		if (!checkPermission(new String[] { "all_employee" })) {
			ModelAndView mav = new ModelAndView("admin/common/access_denied");
			return mav;
		}
		ModelAndView mav = new ModelAndView("admin/user/update");
		User result = userRepository.findById(id).get();
		List<Role> roles = roleRepository.findAll();
		mav.addObject("result", result);
		mav.addObject("roles", roles);
		return mav;
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateSigle(HttpServletRequest request, @PathVariable Long id,
			@ModelAttribute("result") User bodyData) {
		System.out.println(bodyData);
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String roleId = request.getParameter("roleId");
		Role roleInfo = roleRepository.findOneById(Long.parseLong(roleId));
		User userInfo = userRepository.findOneById(id);

		userInfo.setEmail(email);
		userInfo.setFullname(fullname);
		userInfo.setPhone(phone);
		userInfo.setAddress(address);
		userInfo.setGender(gender);
		userInfo.setRole(roleInfo);
		userRepository.save(userInfo);
		return "redirect:../user/list";
	}
	
	@Override
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public @ResponseBody ModelAndView get(HttpServletRequest request, Model model) {
		if (!checkPermission(new String[] { "all_employee" })) {
			ModelAndView mav = new ModelAndView("admin/common/access_denied");
			return mav;
		}
		ModelAndView mav = new ModelAndView("admin/user/create");
		User result = new User();
		List<Role> roles = roleRepository.findAll();
		mav.addObject("result", result);
		mav.addObject("roles", roles);
		return mav;
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String CreateSingle(HttpServletRequest request, @ModelAttribute("result") User bodyData) {
		System.out.println(bodyData);
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String roleId = request.getParameter("roleId");
		String password = request.getParameter("password");
		Role roleInfo = roleRepository.findOneById(Long.parseLong(roleId));
		User userInfo = new User();

		userInfo.setEmail(email);
		userInfo.setFullname(fullname);
		userInfo.setPhone(phone);
		userInfo.setAddress(address);
		userInfo.setGender(gender);
		userInfo.setRole(roleInfo);
		userInfo.setPassword(new BCryptPasswordEncoder().encode(password));
		userRepository.save(userInfo);
		return "redirect:../user/list";
	}
}
