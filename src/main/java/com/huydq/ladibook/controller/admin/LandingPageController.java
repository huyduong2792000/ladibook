package com.huydq.ladibook.controller.admin;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huydq.ladibook.entity.LandingPage;
import com.huydq.ladibook.entity.Template;
import com.huydq.ladibook.repositories.LandingPageRepository;
import com.huydq.ladibook.repositories.ProductRepository;
import com.huydq.ladibook.repositories.ProductTypeRepository;
import com.huydq.ladibook.repositories.TemplateRepository;

@Controller
@RequestMapping(value = "/admin/landingpage")
public class LandingPageController extends BaseController<LandingPage, Long> {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	ProductTypeRepository productTypeRepository;
	@Autowired
	TemplateRepository templateRepository;

	@Autowired
	private LandingPageRepository landingPageRepository;

	// Key dùng để map editor người dùng với landinglage đã tạo
	private String keyMapEditorLandingpage = "keyMapEditorLandingpage_%s";

	@Autowired
	Environment env;

	@Autowired
	public LandingPageController(LandingPageRepository repository) {
		super(repository);
		super.setViewFolder("admin/landingpage");
		super.setApiName("landingpage");
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "editor", method = RequestMethod.GET)
	public String editor(HttpServletRequest request) {
		return "admin/landingpage/editor";
	}

	@RequestMapping(value = "editor/{templateNo}", method = RequestMethod.GET)
	public ModelAndView editorSingle(HttpServletRequest request, @PathVariable String templateNo,
			@RequestParam(name = "productId", required = false, defaultValue = "") String productId) {
		ModelAndView mav = new ModelAndView("admin/editor/editor" + "-" + templateNo + "/index");

		Template template = templateRepository.findOneByTemplateNo(templateNo);
		mav.addObject("template", template);
		mav.addObject("landingpage", null);
		return mav;
	}

	@RequestMapping(value = "editor/{templateNo}/{landingpageId}", method = RequestMethod.GET)
	public ModelAndView editorSingleWithLandingpage(HttpServletRequest request, @PathVariable String templateNo,
			@PathVariable String landingpageId,
			@RequestParam(name = "productId", required = false, defaultValue = "") String productId) {
		ModelAndView mav = new ModelAndView("admin/editor/editor" + "-" + templateNo + "/index");

		Template template = templateRepository.findOneByTemplateNo(templateNo);
		mav.addObject("template", template);
		LandingPage landingPageInfo = landingPageRepository.findOneById(Long.parseLong(landingpageId));
		mav.addObject("landingpage", landingPageInfo);

		return mav;
	}

	@RequestMapping(value = "editor/save-landingpage", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody Map<String, Object> CreateSingle(HttpServletRequest request, @RequestBody Map<String, String> body) {

		LandingPage newLandingPage = new LandingPage();


		return saveEditorLandingpage(request, body, newLandingPage);
	}

	@RequestMapping(value = "editor/save-landingpage/{landingpageId}", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody Map<String, Object> UpdateSingle(HttpServletRequest request,
			@RequestBody Map<String, String> body,
			@PathVariable String landingpageId) {

		LandingPage landingPage = landingPageRepository.findOneById(Long.parseLong(landingpageId));

		return saveEditorLandingpage(request, body, landingPage);
	}

	public @ResponseBody Map<String, Object> saveEditorLandingpage(HttpServletRequest request,
			@RequestBody Map<String, String> body, LandingPage landingPageInfo) {
		Map<String, Object> res = new HashMap<>();
		String pageContent = body.get("pageContent");
		String landingPageName = body.getOrDefault("landingPageName", "New LadiBook Name");
		String templateNo = body.get("templateNo");

		System.out.println(templateNo);
		Template templateInfo = templateRepository.findOneByTemplateNo(templateNo);
		System.out.println(templateInfo);

		landingPageInfo.setThumbnailUrl(templateInfo.getThumbnail());
		landingPageInfo.setLandingPageName(landingPageName);
		landingPageInfo.setStatus("active");
		landingPageInfo.setTemplateNo(templateNo);
		landingPageInfo = landingPageRepository.save(landingPageInfo);

//		System.out.println(body);
		System.out.println(landingPageInfo.toString());
		try {
			FileWriter myWriter = new FileWriter(
					String.format("%s/%s.html", env.getProperty("baseDir"), String.valueOf(landingPageInfo.getId())));
			myWriter.write(pageContent);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");

			res.put("success", true);
			res.put("result", landingPageInfo);
			landingPageInfo = landingPageRepository.save(landingPageInfo);
			landingPageInfo.setDomain(body.getOrDefault("domain",
					"http://localhost:8080/ladibook/landingpage/" + String.valueOf(landingPageInfo.getId())));
			landingPageInfo = landingPageRepository.save(landingPageInfo);
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
			res.put("success", false);
			res.put("result", null);
		}
		return res;
	}

	@Override
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll(HttpServletRequest request,
			@RequestParam(name = "pageIndex", required = false, defaultValue = "0") long pageIndex,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") long pageSize,
			@RequestParam(name = "sortBy", required = false, defaultValue = "id:ASC") String sortBy) {

		ModelAndView mav = new ModelAndView("admin/landingpage/list");
		String status = request.getParameter("status");
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

		Pageable pageQuery = PageRequest.of((int) pageIndex, (int) pageSize, sort);
		List<LandingPage> results = null;
		if (status != null) {
			results = landingPageRepository.findAllByStatus(status, pageQuery).getContent();
		} else {
			results = landingPageRepository.findAll(pageQuery).getContent();
		}

		mav.addObject("default", "default");
		mav.addObject("pageIndex", pageIndex);
		mav.addObject("totalPage", totalPage);
		mav.addObject("results", results);
		return mav;
	}
}
