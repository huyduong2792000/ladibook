package com.huydq.ladibook.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huydq.ladibook.entity.Customer;
import com.huydq.ladibook.repositories.CustomerRepository;
import com.huydq.ladibook.repositories.LandingPageRepository;
import com.huydq.ladibook.repositories.OrderCustomerRepository;
import com.huydq.ladibook.repositories.OrderRepository;

@Controller
@RequestMapping(value = "/admin/customer")
public class CustomerController extends BaseController<Customer, Long> {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	private LandingPageRepository landingPageRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OrderCustomerRepository orderCustomerRepository;

	@Autowired
	public CustomerController(CustomerRepository repository) {
		super(repository);
		super.setViewFolder("admin/customer");
		super.setApiName("customer");
		super.setListViewPermission(new String[] { "read_contact" });
		// TODO Auto-generated constructor stub
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateSigle(HttpServletRequest request, @PathVariable Long id,
			@ModelAttribute("result") Customer bodyData) {
		if (!checkPermission(new String[] { "update_contact" })) {
			return "redirect:/ladibook/admin/access-denined";
		}
		System.out.println(bodyData);
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		Customer customer = customerRepository.findOneById(id);
		customer.setEmail(email);
		customer.setFullname(fullname);
		customer.setPhone(phone);
		customer.setAddress(address);
		customer.setGender(gender);
		customerRepository.save(customer);
		return "redirect:../customer/list";
	}
}
