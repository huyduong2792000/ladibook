package com.huydq.ladibook.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class OrderManagementAdminController {

//	@Autowired
//	private OrderService orderService;
//	
//	@Autowired
//	private ItemService itemService;
//	
//	@GetMapping(value = "/order-list")
//	public String findAll(HttpServletRequest request) {
//		int pageIndex = 0;
//		int pageSize = 10;
//		int totalPage = 0;
//		if (request.getParameter("pageIndex") != null) {
//			pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
//		}
//		int count = orderService.count();
//		if (count % 10 == 0) {
//			totalPage = count / pageSize;
//		} else {
//			totalPage = count / pageSize + 1;
//		}
//		request.setAttribute("totalPage", totalPage);
//		request.setAttribute("pageIndex", pageIndex);
//		request.setAttribute("orders", orderService.findAll(pageIndex, pageSize));
//		return "admin/order/order_list";
//	}
//	
//	@GetMapping(value = "order-updateHome")
//	public String orderUpdateHome(HttpServletRequest request) {
//		long orderId = Long.parseLong(request.getParameter("orderId"));
//		OrderDTO orderDTO = orderService.findById(orderId);
//		orderDTO.setStatus("SUCCESS");
//		orderService.update(orderDTO);
//		return "redirect:/admin/home";
//	}
//
//	
//	@GetMapping(value = "order-update")
//	public String orderUpdate(HttpServletRequest request) {
//		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
//		long orderId = Long.parseLong(request.getParameter("orderId"));
//		OrderDTO orderDTO = orderService.findById(orderId);
//		orderDTO.setStatus("SUCCESS");
//		orderService.update(orderDTO);
//		return "redirect:../admin/order-list?pageIndex=" + pageIndex;
//	}
//	
//	@GetMapping(value = "order-details")
//	public String orderDetails(HttpServletRequest request) {
//		long orderId = Long.parseLong(request.getParameter("orderId"));
//		request.setAttribute("items", itemService.findByOrderId(orderId));
//		request.setAttribute("order", orderService.findById(orderId));
//		return "admin/order/order_details";
//	}
	
}
