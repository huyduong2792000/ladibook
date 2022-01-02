package com.huydq.ladibook.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huydq.ladibook.entity.Customer;
import com.huydq.ladibook.entity.OrderCustomer;
import com.huydq.ladibook.entity.User;
import com.huydq.ladibook.repositories.CustomerRepository;
import com.huydq.ladibook.repositories.LandingPageRepository;
import com.huydq.ladibook.repositories.OrderCustomerRepository;
import com.huydq.ladibook.repositories.OrderRepository;
import com.huydq.ladibook.repositories.RoleRepository;
import com.huydq.ladibook.repositories.UserRepository;

@Controller
@RequestMapping(value = "/admin/order")
public class OrderController extends BaseController<OrderCustomer, Long> {

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

	@Autowired
	public OrderController(OrderCustomerRepository repository) {
		super(repository);
		super.setViewFolder("admin/order");
		super.setApiName("order");
		super.setListViewPermission(new String[] { "read_order" });
		// TODO Auto-generated constructor stub
	}

	@Override
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll(HttpServletRequest request,
			@RequestParam(name = "pageIndex", required = false, defaultValue = "0") long pageIndex,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") long pageSize,
			@RequestParam(name = "sortBy", required = false, defaultValue = "id:ASC") String sortBy) {

		if (!checkPermission(new String[] { "read_order" })) {
			ModelAndView mav = new ModelAndView("admin/common/access_denied");
			return mav;
		}
		ModelAndView mav = new ModelAndView("admin/order/list");
		String status = request.getParameter("status");
		String landingpageId = request.getParameter("landingpageId");
		String customerId = request.getParameter("customerId");
		String employeeId = request.getParameter("employeeId");
		long totalPage = 0;

		long count = (long) repository.count();
		if (count != 0 && count % pageSize == 0) {
			totalPage = count / pageSize;
		} else {
			totalPage = count / pageSize + 1;
		}
		String[] sortList = sortBy.split(";");

		// Đoạn này sau này phải sửa lại
		Sort sort = null;
		for (String sortParam : sortList) {
			String[] sortDetail = sortParam.split(":");
			if (sortDetail[1] == "ASC") {
				sort = Sort.by(sortDetail[0]);
			} else {
				sort = Sort.by(sortDetail[0]).descending();
			}
		}

		List<OrderCustomer> results = null;
		Pageable pageQuery = PageRequest.of((int) pageIndex, (int) pageSize, sort);
		if (landingpageId != null) {
			results = orderCustomerRepository.findAllByLandingPageId(Long.parseLong(landingpageId), pageQuery)
					.getContent();
		} else if (employeeId != null) {
			results = orderCustomerRepository.findAllByEmployeeId(Long.parseLong(employeeId), pageQuery).getContent();
		} else if (customerId != null) {
			results = orderCustomerRepository.findAllByCustomerId(Long.parseLong(customerId), pageQuery).getContent();
		} else if (status != null) {
			results = orderCustomerRepository.findAllByStatus(status, pageQuery).getContent();
		} else {
			results = (List<OrderCustomer>) orderCustomerRepository.findAll(pageQuery).getContent();
		}
		mav.addObject("default", "default");
		mav.addObject("pageIndex", pageIndex);
		mav.addObject("totalPage", totalPage);
		mav.addObject("results", results);
		return mav;
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getSingle(HttpServletRequest request, @PathVariable Long id) {
		if (!checkPermission(new String[] { "read_order" })) {
			ModelAndView mav = new ModelAndView("admin/common/access_denied");
			return mav;
		}
		ModelAndView mav = new ModelAndView("admin/order/update");
		OrderCustomer result = orderCustomerRepository.findById(id).get();
		List<User> employees = userRepository.findAll();
		mav.addObject("result", result);
		mav.addObject("employees", employees);
		return mav;
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateSigle(HttpServletRequest request, @PathVariable Long id,
			@ModelAttribute("result") OrderCustomer bodyData) {
		if (!checkPermission(new String[] { "update_order" })) {
			return "redirect:/ladibook/admin/access-denined";
		}
		System.out.println(bodyData);
		String employeeId = request.getParameter("employeeId");
		String status = request.getParameter("status");
		OrderCustomer orderCustomer = orderCustomerRepository.findOneById(id);
		User employeeInfo = userRepository.findOneById(Long.parseLong(employeeId));
		orderCustomer.setEmployee(employeeInfo);
		orderCustomer.setStatus(status);
		repository.save(orderCustomer);
		return "redirect:../order/list";
	}

	@RequestMapping(value = "/send-mail", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getSendMail(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/order/send-mail");
		String[] customerIds = request.getParameterValues("customerId");
		String customerId = "";
		for (String id : customerIds) {
			customerId = id + ";";
		}
		mav.addObject("customerId", customerId);
		return mav;
	}

	@RequestMapping(value = "/send-mail", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> postSendMail(HttpServletRequest request,
			@RequestBody Map<String, String> body) {
		Map<String, Object> res = new HashMap<>();
		String customerIds = body.get("customerId");
		String title = body.get("title");
		String content = body.get("content");
		System.out.println(customerIds);
		System.out.println(content);
		for (String customerId : customerIds.split(";")) {
			Customer customerInfo = customerRepository.findOneById(Long.parseLong(customerId));
			sendEmail("duongquanghuy2792000@gmail.com", customerInfo.getEmail(), title, content);
		}
		res.put("success", true);
		return res;
	}

	public void sendEmail(String from, String to, String subject, String content) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);

		mailSender.send(mailMessage);
	}
}
