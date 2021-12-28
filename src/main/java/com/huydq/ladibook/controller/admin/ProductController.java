package com.huydq.ladibook.controller.admin;

import java.text.NumberFormat;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.huydq.ladibook.entity.Product;
import com.huydq.ladibook.entity.ProductType;
import com.huydq.ladibook.repositories.ProductRepository;
import com.huydq.ladibook.repositories.ProductTypeRepository;

@Controller
@RequestMapping(value = "/admin/product")
public class ProductController extends BaseController<Product, Long> {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	ProductTypeRepository productTypeRepository;

	@Autowired
	public ProductController(ProductRepository repository) {
		super(repository);
		super.setViewFolder("admin/product");
		super.setApiName("product");
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "create-product-type", method = RequestMethod.GET)
	public @ResponseBody String createProductType(HttpServletRequest request) {
		Hashtable<String, String> productTypes = new Hashtable<String, String>();
		productTypes.put("product", "Sản phẩm");
		productTypes.put("promotion", "Khuyến mãi");
		productTypes.put("service", "Dịch vụ");
		productTypes.put("combo", "Combo");
		for (Map.Entry<String, String> e : productTypes.entrySet()) {
			String productNo = e.getKey();
			String productName = e.getValue();
			ProductType productType = productTypeRepository.findOneByProductTypeNo(productNo);
			if (productType == null) {
				productType = productTypeRepository.save(new ProductType(productNo, productName, ""));
			} else {
				productType.setProductTypeNo(productNo);
				productType.setProductTypeName(productName);
				productTypeRepository.save(productType);
			}
		}

		return "OK";
	}

	@Override
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listAll(HttpServletRequest request,
			@RequestParam(name = "pageIndex", required = false, defaultValue = "0") long pageIndex,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") long pageSize,
			@RequestParam(name = "sortBy", required = false, defaultValue = "Id:ASC") String sortBy) {
		ModelAndView mav = new ModelAndView("admin/product/list");
		String categoriesParam = request.getParameter("categories");
		String productNameParam = request.getParameter("productName");
		String productTypeParam = request.getParameter("productType");
		long totalPage = 0;
		long count = 0;

		if (productTypeParam == null) {
			productTypeParam = "product";
		}

		ProductType productType = productTypeRepository.findOneByProductTypeNo(productTypeParam);

		if (productType != null && productType.getProductTypeNo() == "product") {
			count = productRepository.countByProductType(productType);
		} else {
			count = productRepository.countByProductType(productType);
		}

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
		List<Product> results = null;
		if (productType != null && productType.getProductTypeNo() == "product") {
			results = productRepository.findAllByProductType(productType, pageQuery).getContent();
		} else {
			results = productRepository.findAllByProductType(productType, pageQuery).getContent();
		}
		mav.addObject("default", "default");
		mav.addObject("pageIndex", pageIndex);
		mav.addObject("totalPage", totalPage);
		mav.addObject("results", results);
		
		// Cho vào để nút create điều hướng
		mav.addObject("productType", productTypeParam);
		return mav;
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String CreateSingle(HttpServletRequest request, @ModelAttribute("result") Product bodyData) {
		String productTypeParam = request.getParameter("productTypeNo");
		if (bodyData.getProductType() == null) {
			if (productTypeParam == null) {
				ProductType defaultProductType = productTypeRepository.findOneByProductTypeNo("product");
				bodyData.setProductType(defaultProductType);
			} else {
				ProductType defaultProductType = productTypeRepository.findOneByProductTypeNo(productTypeParam);
				bodyData.setProductType(defaultProductType);
			}
		}
		if (bodyData.getPriceLabel() == null) {
			Locale locale = new Locale("vn", "VN");
			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
			bodyData.setPriceLabel(currencyFormatter.format(bodyData.getPrice()));
		}
		productRepository.save(bodyData);
		return "redirect:../product/list";
	}

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public @ResponseBody ModelAndView get(HttpServletRequest request, Model model) {
		String productTypeParam = request.getParameter("productType");
		List<ProductType> allProductTypes = productTypeRepository.findAll();
		ModelAndView mav = new ModelAndView("admin/product/create");
		Product result = new Product();
		mav.addObject("result", result);
		mav.addObject("currentProductType", productTypeParam);
		mav.addObject("allProductType", allProductTypes);
		return mav;
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getSingle(HttpServletRequest request, @PathVariable Long id) {
		ModelAndView mav = new ModelAndView("admin/product/update");
		Product result = productRepository.findById(id).get();
		List<ProductType> allProductTypes = productTypeRepository.findAll();
		mav.addObject("result", result);
		mav.addObject("allProductType", allProductTypes);
		mav.addObject("currentProductType", result.getProductType().getProductTypeNo());
		return mav;
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateSigle(HttpServletRequest request, @PathVariable Long id,
			@ModelAttribute("result") Product bodyData) {
		System.out.println(bodyData);
		String productTypeParam = request.getParameter("productTypeNo");
		if (bodyData.getProductType() == null) {
			if (productTypeParam == null) {
				ProductType defaultProductType = productTypeRepository.findOneByProductTypeNo("product");
				bodyData.setProductType(defaultProductType);
			} else {
				ProductType defaultProductType = productTypeRepository.findOneByProductTypeNo(productTypeParam);
				bodyData.setProductType(defaultProductType);
			}
		}
		if (bodyData.getPriceLabel() == null) {
			Locale locale = new Locale("vn", "VN");
			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
			bodyData.setPriceLabel(currencyFormatter.format(bodyData.getPrice()));
		}
		repository.save(bodyData);
		return "redirect:../product/list";
	}
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public ModelAndView filter(HttpServletRequest request,
//			@RequestParam(name = "pageIndex", required = false, defaultValue = "0") long pageIndex,
//			@RequestParam(name = "pageSize", required = false, defaultValue = "10") long pageSize,
//			@RequestParam(name = "sortBy", required = false, defaultValue = "Id:ASC") String sortBy,
//			@RequestParam(name = "categories", required = false, defaultValue = "") String categories,
//			@RequestParam(name = "productType", required = false, defaultValue = "") String productType) {
//
//		ModelAndView mav = new ModelAndView("admin/product/list");
//		long totalPage = 0;
//
//		long count = productTypeRepository.count();
//		if (count % pageSize == 0) {
//			totalPage = count / pageSize;
//		} else {
//			totalPage = count / pageSize + 1;
//		}
//		String[] sortList = sortBy.split(";");
//
//		// Đoạn này sau này phải sửa lại
//		Sort sort = null;
//		for (String sortParam : sortList) {
//			String[] sortDetail = sortParam.split(":");
//			if (sortDetail[1] == "ASC") {
//				sort = Sort.by(sortDetail[0]);
//			} else {
//				sort = Sort.by(sortDetail[0]).descending();
//			}
//		}
//
//		Pageable pageQuery = PageRequest.of((int) pageIndex, (int) pageSize, sort);
//		List<Product> results = repository.findAll(pageQuery).getContent();
//		mav.addObject("default", "default");
//		mav.addObject("pageIndex", pageIndex);
//		mav.addObject("totalPage", totalPage);
//		mav.addObject("results", results);
//		return mav;
//	}
//	@Autowired
//	public ProductController(String viewFolder) {
//		super(viewFolder);
//		// TODO Auto-generated constructor stub
//	}


//	@GetMapping(value = "")
//	public String findAll(HttpServletRequest request,
//			@RequestParam(name = "pageIndex", required = false, defaultValue = "0") int pageIndex,
//			@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
//			@RequestParam(name = "sortBy", required = false, defaultValue = "Id:ASC") String sortBy) {
////		pageIndex = getRequestPageIndex(request);
//		int totalPage = 0;
//
//		int count = (int) repository.count();
//		if (count % pageSize == 0 && count != 0) {
//			totalPage = count / pageSize;
//		} else {
//			totalPage = count / pageSize + 1;
//		}
//		String[] sortList = sortBy.split(";");
//
//		// Đoạn này sau này phải sửa lại
//		Sort sort = null;
//		for (String sortParam : sortList) {
//			String[] sortDetail = sortParam.split(":");
//			if (sortDetail[1] == "ASC") {
//				sort = Sort.by(sortDetail[0]);
//			} else {
//				sort = Sort.by(sortDetail[0]).descending();
//			}
//		}
//
//		Pageable pageQuery = PageRequest.of(pageIndex, 5, sort);
////		
//		request.setAttribute("default", "default");
//		request.setAttribute("pageIndex", pageIndex);
//		request.setAttribute("totalPage", totalPage);
//
//		request.setAttribute("results", repository.findAll(pageQuery));
//		return viewFolder + "/list";
//	}
//	
//	// Show all product by category
//	
//	@GetMapping(value = "/product-list-by-category")
//	public String findAllByCategory(HttpServletRequest request, @RequestParam(name = "categoryId") long categoryId) {
//		int pageIndex = 0;
//		int pageSize = 5;
//		
//		if (request.getParameter("pageIndex") != null) {
//			pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
//		}
//		int totalPage = 0;
//		int count = productService.countByCategoryId(categoryId);
//		if (count % pageSize == 0) {
//			totalPage = count / pageSize;
//		} else {
//			totalPage = count / pageSize + 1;
//		}
//		
//		request.setAttribute("categoryId", categoryId);
//		request.setAttribute("pageIndex", pageIndex);
//		request.setAttribute("totalPage", totalPage);
//		request.setAttribute("products", productService.findAllByCategoryId(categoryId, pageIndex, pageSize));
//		return "admin/product/listProductByCategory";
//	}
//	
//	// Create new product
//	
//	@GetMapping(value="/product-create")
//	public String insert(HttpServletRequest request) {
//		request.setAttribute("categories", categoryService.findAll());
//		request.setAttribute("sales", saleService.findAll());
//	return"admin/product/createNewProduct";
//
//	}
//	
//	@PostMapping(value = "/product-create")
//	public String insertPost(HttpServletRequest request, @RequestParam(name = "categoryId") long categoryId,
//			@RequestParam(name = "productName") String productName,
//			@RequestParam(name = "description") String description,
//			@RequestParam(name = "price") float price,
//			@RequestParam(name = "quantity") int quantity,
//			@RequestParam(name = "saleId") String saleId,
//			@RequestParam(name = "imageFile") MultipartFile imageFile) {
//		CategoryDTO categoryDTO = new CategoryDTO();
//		categoryDTO.setCategoryId(categoryId);
//		SaleDTO saleDTO = new SaleDTO();
//		saleDTO.setSaleId(saleId);
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setCategoryDTO(categoryDTO);
//		productDTO.setSaleDTO(saleDTO);
//		productDTO.setProductName(productName);
//		productDTO.setDescription(description);
//		productDTO.setPrice(price);
//		productDTO.setQuantity(quantity);
//		if (imageFile != null && imageFile.getSize() > 0) {
//			String originalFilename = imageFile.getOriginalFilename();
//			int lastIndex = originalFilename.lastIndexOf(".");
//			String ext = originalFilename.substring(lastIndex);
//			String avatarFilename = System.currentTimeMillis() + ext;
//			File newfile = new File("C:\\image_spring_boot\\" + avatarFilename);
//			FileOutputStream fileOutputStream;
//			try {
//				fileOutputStream = new FileOutputStream(newfile);
//				fileOutputStream.write(imageFile.getBytes());
//				fileOutputStream.close();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			productDTO.setImage(avatarFilename);
//		}
//		
//		productService.insert(productDTO);
//		return "redirect:../admin/product-list";
//	}
//	
//	
	// Update product
//	
//	@GetMapping(value = "/product-update")
//	public String update(HttpServletRequest request, @RequestParam(name = "productId") long productId) {
//		request.setAttribute("product", productService.findById(productId));
//		request.setAttribute("sales", saleService.findAll());
//		request.setAttribute("categories", categoryService.findAll());
//		return "admin/product/updateProduct";
//	}
//	
//	@PostMapping(value = "/product-update")
//	public String update(HttpServletRequest request, @RequestParam(name = "newPrice", required = false) String newPrice,
//			@RequestParam(name = "imageFile", required = false) MultipartFile imageFile) {
//		long productId = Long.parseLong(request.getParameter("productId"));
//		long categoryId = Long.parseLong(request.getParameter("categoryId")); 
//		float oldprice = Float.parseFloat(request.getParameter("oldPrice"));
//		String productName = request.getParameter("productName");
//		String description = request.getParameter("description");
//		int quantity = Integer.parseInt(request.getParameter("quantity"));
//		String image = request.getParameter("image");
//		String saleId = request.getParameter("saleId");
//		
//		SaleDTO saleDTO = new SaleDTO();
//		saleDTO.setSaleId(saleId);
//		CategoryDTO categoryDTO = new CategoryDTO();
//		categoryDTO.setCategoryId(categoryId);
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProductId(productId);
//		productDTO.setSaleDTO(saleDTO);
//		productDTO.setCategoryDTO(categoryDTO);
//		productDTO.setProductName(productName);
//		productDTO.setDescription(description);
//		productDTO.setQuantity(quantity);
//		if (newPrice == null || newPrice.equals("")) {
//			productDTO.setPrice(oldprice);
//		} else {
//			productDTO.setPrice(Float.parseFloat(newPrice));
//		}
//		if (imageFile != null && imageFile.getSize() > 0) {
//			String originalFilename = imageFile.getOriginalFilename();
//			int lastIndex = originalFilename.lastIndexOf(".");
//			String ext = originalFilename.substring(lastIndex);
//			String avatarFilename = System.currentTimeMillis() + ext;
//			File newfile = new File("C:\\image_spring_boot\\" + avatarFilename);
//			FileOutputStream fileOutputStream;
//			try {
//				fileOutputStream = new FileOutputStream(newfile);
//				fileOutputStream.write(imageFile.getBytes());
//				fileOutputStream.close();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			productDTO.setImage(avatarFilename);
//		} else {
//			productDTO.setImage(image);
//		}
//		
//		productService.update(productDTO);
//		return "redirect:/admin/product-list";
//	}
//	
//	// Delete Product
//	
//	@GetMapping(value = "/product-delete")
//	public String delete(HttpServletRequest request) {
//		String[] productIds = request.getParameterValues("productId");
//		for (String productId : productIds) {
//			productService.delete(Long.parseLong(productId));
//		}
//		return "redirect:../admin/product-list";
//	}
}
