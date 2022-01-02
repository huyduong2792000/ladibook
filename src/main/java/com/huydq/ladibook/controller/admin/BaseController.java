package com.huydq.ladibook.controller.admin;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huydq.ladibook.entity.Permission;
import com.huydq.ladibook.repositories.RoleRepository;

public abstract class BaseController<T, ID> {

	private Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	private RoleRepository roleRepository;

	private String viewFolder;

	private String apiName;

	private String[] listViewPermission;

	public String[] getListViewPermission() {
		return listViewPermission;
	}

	public void setListViewPermission(String[] listViewPermission) {
		this.listViewPermission = listViewPermission;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public PagingAndSortingRepository<T, ID> repository;

	public BaseController(PagingAndSortingRepository<T, ID> repository) {
		this.repository = repository;
	}

	public BaseController(String viewFolder) {
		this.viewFolder = viewFolder;
	}

	public String getViewFolder() {
		return viewFolder;
	}

	public void setViewFolder(String viewFolder) {
		this.viewFolder = viewFolder;
	}

	public ModelAndView customGetAll(HttpServletRequest request, long pageIndex, long pageSize, String sortBy) {
		return null;
	}

	public boolean checkPermission(String[] permissions) {
		if (permissions == null) {
			return true;
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		for (String permission : permissions) {
			for (GrantedAuthority roleName : auth.getAuthorities()) {
				Set<Permission> rolePermissions = roleRepository
						.findOneByRoleName(roleName.getAuthority()).getPermissions();
				for (Permission rolePermission : rolePermissions) {
					if (rolePermission.getPermissionNo().equals(permission)) {
						return true;
					}
				}
			}
		}
		return false;
	}
//	public String customPost(T bodyData) {
//		return null;
//	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(HttpServletRequest request) {
		return "redirect:" + apiName + "/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll(HttpServletRequest request,
			@RequestParam(name = "pageIndex", required = false, defaultValue = "0") long pageIndex,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") long pageSize,
			@RequestParam(name = "sortBy", required = false, defaultValue = "id:ASC") String sortBy) {

		if (!checkPermission(listViewPermission)) {
			ModelAndView mav = new ModelAndView("admin/common/access_denied");
			return mav;
		}
		ModelAndView mav = new ModelAndView(this.viewFolder + "/list");
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
		List<T> results = (List<T>) repository.findAll(pageQuery).getContent();
		mav.addObject("default", "default");
		mav.addObject("pageIndex", pageIndex);
		mav.addObject("totalPage", totalPage);
		mav.addObject("results", results);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getSingle(HttpServletRequest request, @PathVariable ID id) {
		ModelAndView mav = new ModelAndView(this.viewFolder + "/update");
		T result = (T) repository.findById(id).get();
		mav.addObject("result", result);
		return mav;
	}


	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public @ResponseBody ModelAndView get(HttpServletRequest request, Model model) {
		ModelAndView mav = new ModelAndView(this.viewFolder + "/create");
		T result = null;
		try {
			result = (T) repository.getClass().newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("result", result);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String CreateSingle(HttpServletRequest request, @ModelAttribute("result") T bodyData) {
		System.out.println(bodyData);
		repository.save(bodyData);
		return "redirect:../" + apiName + "/list";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateSigle(HttpServletRequest request, @PathVariable ID id, @ModelAttribute("result") T bodyData) {
		System.out.println(bodyData);
		repository.save(bodyData);
		return "redirect:../" + apiName + "/list";
	}
	@RequestMapping(value = "delete-many", method = RequestMethod.GET)
	public String deleteMany(HttpServletRequest request) {
		String[] Ids = request.getParameterValues("id");
//		System.out.println(Ids);
		for (String Id : Ids) {
			Long id = Long.parseLong(Id);
			repository.deleteById((ID) (id));
		}
		return "redirect:../" + apiName + "/list";
	}
}
