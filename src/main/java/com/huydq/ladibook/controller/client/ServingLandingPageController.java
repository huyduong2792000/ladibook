package com.huydq.ladibook.controller.client;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huydq.ladibook.entity.LandingPage;
import com.huydq.ladibook.repositories.LandingPageRepository;

@Controller
@RequestMapping(value = "/landingpage")
public class ServingLandingPageController {

//	@Autowired
//	private CategoryService categoryService;
//	
//	@Autowired
//	private ProductService productService;
	@Autowired
	private LandingPageRepository landingPageRepository;
	@Autowired
	Environment env;

	@GetMapping(value = "/{landingpageId}")
	public @ResponseBody ModelAndView servingLandingpage(HttpServletRequest request, @PathVariable Long landingpageId) {
		ModelAndView mav = new ModelAndView("client/landingpage");
		try {
			FileInputStream inputStream = new FileInputStream(
					String.format("%s/%s.html", env.getProperty("baseDir"), String.valueOf(landingpageId)));
			String pageContent = IOUtils.toString(inputStream);
			mav.addObject("pageContent", pageContent);
			LandingPage landingPageInfo = landingPageRepository.findOneById(landingpageId);
			landingPageInfo.setViewCount(landingPageInfo.getViewCount() + 1);
			landingPageRepository.save(landingPageInfo);
		} catch (IOException e) {
			System.out.println(e);
		}
			return mav;

	}
}
