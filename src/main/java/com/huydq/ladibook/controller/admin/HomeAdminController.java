package com.huydq.ladibook.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.MailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.huydq.ladibook.entity.OrderCustomer;
import com.huydq.ladibook.repositories.CustomerRepository;
import com.huydq.ladibook.repositories.LandingPageRepository;
import com.huydq.ladibook.repositories.OrderCustomerRepository;
import com.huydq.ladibook.repositories.OrderRepository;
import com.huydq.ladibook.repositories.RoleRepository;
import com.huydq.ladibook.repositories.UserRepository;

@Controller
@RequestMapping(value = "/admin")
public class HomeAdminController {

//	@Autowired
//	private OrderService orderService;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	private LandingPageRepository landingPageRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OrderCustomerRepository orderCustomerRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MailSender mailSender;
	
	@GetMapping(value = "")
	public String blankHome(HttpServletRequest request) {
		return "redirect:../home";
	}

	@GetMapping(value = "/")
	public String slashHome(HttpServletRequest request) {
		return "redirect:home";
	}

	@GetMapping(value = "/home")
	public ModelAndView home(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/home");
		mav.addObject("viewCount", orderCustomerRepository.sumViewCount());
		mav.addObject("orderCount", orderCustomerRepository.sumOrderCount());
		mav.addObject("customerCount", customerRepository.count());
		mav.addObject("landingPageCount", landingPageRepository.count());
		Sort sort = Sort.by("id").descending();
		Pageable pageQuery = PageRequest.of((int) 0, (int) 5, sort);
		List<OrderCustomer> recentOrders = orderCustomerRepository.findAll(pageQuery).getContent();
		mav.addObject("recentOrders", recentOrders);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getAuthorities());
		mav.addObject("role", auth.getAuthorities().stream().findFirst());
		return mav;
	}
	
}
