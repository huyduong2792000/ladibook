package com.huydq.ladibook.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huydq.ladibook.entity.Template;
import com.huydq.ladibook.repositories.TemplateRepository;

@Controller
@RequestMapping(value = "/admin/template")
public class TemplateController extends BaseController<Template, Long> {

	@Autowired
	TemplateRepository templateRepository;

	@Autowired
	public TemplateController(TemplateRepository repository) {
		super(repository);
		super.setViewFolder("admin/template");
		super.setApiName("template");
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/template", method = RequestMethod.GET)
	public String redirect(HttpServletRequest request) {
		return "redirect:../../admin/template";
	}

	@RequestMapping(value = "init-template", method = RequestMethod.GET)
	public @ResponseBody String initTemplate(HttpServletRequest request) {
		Template newTemplate = new Template();
		newTemplate.setTemplateName("DEV BOOK - Landingpage về sách");
		newTemplate.setTemplateNo("03");
		newTemplate.setThumbnail("https://ps.mediacdn.vn/huydq/ladibook/template/thumnail_1.png");
		newTemplate.setTemplateType("FREE");
		templateRepository.save(newTemplate);
		return "OK";
	}
}
