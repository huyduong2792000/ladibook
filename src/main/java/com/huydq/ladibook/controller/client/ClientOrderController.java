package com.huydq.ladibook.controller.client;

import java.text.DecimalFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.huydq.ladibook.controller.admin.BaseController;
import com.huydq.ladibook.entity.Customer;
import com.huydq.ladibook.entity.LandingPage;
import com.huydq.ladibook.entity.Order;
import com.huydq.ladibook.entity.OrderCustomer;
import com.huydq.ladibook.entity.Role;
import com.huydq.ladibook.entity.User;
import com.huydq.ladibook.repositories.CustomerRepository;
import com.huydq.ladibook.repositories.LandingPageRepository;
import com.huydq.ladibook.repositories.OrderCustomerRepository;
import com.huydq.ladibook.repositories.OrderRepository;
import com.huydq.ladibook.repositories.RoleRepository;
import com.huydq.ladibook.repositories.UserRepository;

@Controller
@RequestMapping(value = "/order")
public class ClientOrderController extends BaseController<Order, Long> {

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
	public ClientOrderController(OrderRepository repository) {
		super(repository);
		super.setViewFolder("admin/order");
		super.setApiName("order");
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/save-order", method = RequestMethod.POST)
	public ModelAndView CreateSingle(HttpServletRequest request,
			@RequestParam(name = "customerEmails") String customerEmails) {
		System.out.println(customerEmails);
		ModelAndView mav = new ModelAndView("admin/order/success");
		Order newOrder = new Order();
		String hostname = request.getHeader("Host");
		String referer = request.getHeader("Referer");
		Role adminRole = roleRepository.findOneByRoleName("admin");
		User employee = userRepository.findAllbyRoleId(adminRole.getId()).get(0);
		LandingPage landingpageInfo = landingPageRepository.findOneByDomain(referer);
		// N???u t??m ??c landingpage th?? update l?????t order
		if (landingpageInfo != null) {
			int orderCount = landingpageInfo.getOrderCount() + 1;
			int viewCount = landingpageInfo.getViewCount();
			String orderPercent = "0.0";
			landingpageInfo.setOrderCount(orderCount);
			if (viewCount == 0) {
				viewCount = 1;
			}
			DecimalFormat orderPercentFormat = new DecimalFormat("#.##");
			orderPercent = orderPercentFormat
					.format(Math.round((float) orderCount * (float) 100.0 / (float) viewCount));
			landingpageInfo.setOrderPercent(orderPercent);
			landingPageRepository.save(landingpageInfo);
		}

		Date buyDate = new Date();
		newOrder.setBuyDate(buyDate);
		newOrder = orderRepository.save(newOrder);

		for (String customerEmail : customerEmails.split(";")) {
			Customer existCustomer = customerRepository.findOneByEmail(customerEmail);
			if (existCustomer == null) {
				existCustomer = new Customer();
				existCustomer.setEmail(customerEmail);
				customerRepository.save(existCustomer);
			}
			OrderCustomer newOrderCustomer = new OrderCustomer();
			newOrderCustomer.setEmail(customerEmail);
			newOrderCustomer.setCustomer(existCustomer);
			newOrderCustomer.setOrder(newOrder);
			newOrderCustomer.setEmployee(employee);
			newOrderCustomer.setLandingPage(landingpageInfo);
			orderCustomerRepository.save(newOrderCustomer);
			sendEmail("duongquanghuy2792000@gmail.com", customerEmail, "Ch??ng t??i ???? nh???n ???????c y??u c???u c???a b???n",
					"Xin ch??o "
							+ customerEmail + ". "
					+ hostname
					+ " ???? nh???n ???????c v?? x??? l?? y??u c???u c???a b???n, ch??ng t??i s??? b??o l???i ngay khi x??? l?? xong, h??y ????? ?? mail nh??!!!");
		}
		
		return mav;
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
