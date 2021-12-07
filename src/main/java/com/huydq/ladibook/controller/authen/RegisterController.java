package com.huydq.ladibook.controller.authen;

import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huydq.ladibook.entity.Permission;
import com.huydq.ladibook.entity.Role;
import com.huydq.ladibook.entity.User;
import com.huydq.ladibook.repositories.PermissionRepository;
import com.huydq.ladibook.repositories.ProductTypeRepository;
import com.huydq.ladibook.repositories.RoleRepository;
import com.huydq.ladibook.repositories.UserRepository;

@Controller
public class RegisterController {
	
	@Autowired
	private RoleRepository roleRepository;
//
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private ProductTypeRepository productTypeRepository;

	@Autowired
	private MailSender mailSender;

	@GetMapping(value = "/register")
	public String register() {
		return "authen/register";
	}

	@PostMapping(value = "/register")
	public String register(HttpServletRequest request, @RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, @RequestParam(name = "repassword") String repassword) {
		String code = randomString(8);
		if (!password.equals(repassword)) {
			request.setAttribute("error", "The password do not match!");
			request.setAttribute("email", email);
			return "authen/register";
		}
		if (userRepository.findOneByEmail(email) != null) {
			User user = userRepository.findOneByEmail(email);
			if (user.isVerify() == true) {
				request.setAttribute("error", "The email address is already exist!");
				return "authen/register";
			}
			user.setPassword(new BCryptPasswordEncoder().encode(password));
			userRepository.save(user);
			sendEmail("duongquanghuy2792000@gmail.com", email, "Welcome to LadiBook!", "Hello, " + email.split("@")[0]
					+ "! Please confirm that you can login in LadiBook!" + " Your confirmation code is: " + code);
			HttpSession session = request.getSession();
			session.setAttribute("emailRegister", email);
			session.setAttribute("codeVerify", code);
			return "authen/verify";

		}
		Role roleAdmin = roleRepository.findOneByRoleName("admin");
		if (roleAdmin == null) {
			Role newRoleAdmin = new Role();
			newRoleAdmin.setRoleName("admin");
			roleAdmin = roleRepository.save(newRoleAdmin);
		}

		// Khởi tạo permission cho role
		if (roleAdmin.getPermissions().isEmpty()) {
			Permission createPermission = permissionRepository.findOneByPermissionNo("create");
			if (createPermission == null) {
				createPermission = permissionRepository.save(new Permission("create", "Create"));
			}
			roleAdmin.addPermission(createPermission);

			Permission readPermission = permissionRepository.findOneByPermissionNo("read");
			if (readPermission == null) {
				readPermission = permissionRepository.save(new Permission("read", "Read"));
			}
			roleAdmin.addPermission(readPermission);

			Permission updatePermission = permissionRepository.findOneByPermissionNo("update");
			if (updatePermission == null) {
				updatePermission = permissionRepository.save(new Permission("update", "Update"));
			}
			roleAdmin.addPermission(updatePermission);

			Permission deletePermission = permissionRepository.findOneByPermissionNo("delete");
			if (deletePermission == null) {
				deletePermission = permissionRepository.save(new Permission("delete", "Delete"));
			}
			roleAdmin.addPermission(deletePermission);

			roleRepository.save(roleAdmin);
		}

		User user = new User();
		user.setEmail(email);
		user.setPassword(new BCryptPasswordEncoder().encode(password));
		user.setAvatar("https://toigingiuvedep.vn/wp-content/uploads/2021/06/hinh-anh-gai-xinh-de-thuong-nhat-1.jpg");
		user.setRole(roleAdmin);
		userRepository.save(user);

		sendEmail("duongquanghuy2792000@gmail.com", email, "Welcome to LadiBook!", "Hello, " + email.split("@")[0]
				+ "! Please confirm that you can login in LadiBook!" + " Your confirmation code is: " + code);

		HttpSession session = request.getSession();
		session.setAttribute("emailRegister", email);
		session.setAttribute("codeVerify", code);
		return "authen/verify";
	}

	@GetMapping(value = "/resend-code")
	public String resendCode(HttpSession session, HttpServletRequest request) {
		String code = randomString(8);
		String email = (String) session.getAttribute("emailRegister");
		sendEmail("duongquanghuy2792000@gmail.com", email, "Welcome to LadiBook!", "Hello, " + email.split("@")[0]
				+ "! Please confirm that you can login in LadiBook!" + " Your confirmation code is: " + code);
		request.setAttribute("resend", "resend");
		session.setAttribute("codeVerify", code);
		return "authen/verify";
	}

	@PostMapping(value = "/verify")
	public String verify(HttpServletRequest request, HttpSession session) {
		String code = request.getParameter("code");
		String codeVerify = (String) session.getAttribute("codeVerify");
		if (!code.equals(codeVerify)) {
			request.setAttribute("error", "Invalid code, please try again!");
		} else {
			String email = (String) session.getAttribute("emailRegister");
			User user = userRepository.findOneByEmail(email);
			user.setVerify(true);
			request.setAttribute("verifySuccess", "Verification successfull!");
			request.setAttribute("active", "active");
			userRepository.save(user);
		}
		return "redirect:/login";
	}

//	
//	@PostMapping(value = "get-news")
//	public String getNews(@RequestParam(name = "email") String email) {
//		sendEmail("coosi29@gmail.com", email, "Welcome to FlatShop!",
//				"Thank you for your interest, we will send you the latest notice if any. Please pay attention to your mail.");
//		return "client/get_news";
//	}
//	
	public void sendEmail(String from, String to, String subject, String content) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);

		mailSender.send(mailMessage);
	}
//	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
//
	String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
}
