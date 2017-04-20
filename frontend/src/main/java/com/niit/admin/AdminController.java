package com.niit.admin;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.model.Category;
import com.niit.backend.dao.ProductDAO;
import com.niit.backend.model.Product;
import com.niit.backend.dao.SupplierDAO;
import com.niit.backend.model.Supplier;
@Controller
public class AdminController 
{
	private static final Logger log=LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category  category;
	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDAO supplierDAO;
	@RequestMapping("/clickcate")
	public ModelAndView cate(Map<String, Object> map)
	{
		log.debug("show category list");
	ModelAndView mv=new ModelAndView("/index");
	List<Category> categoryList=	categoryDAO.list();
	  mv.addObject("categoryList", categoryList);
	  mv.addObject("category", category);
	  map.put("list", "categoryList");
	  log.debug("End show category list");
	return mv;
	}
	@RequestMapping("/clicksup")
	public ModelAndView supply(Map<String, Object> map)
	{
		log.debug("show supplier list");
		ModelAndView m=new ModelAndView("/index");
		 List<Supplier> supplierList=	supplierDAO.list();
		  m.addObject("supplierList", supplierList);
		  m.addObject("supplier", supplier);
		  map.put("list", "supplierList");
		  log.debug("End show suppiler list");
		  
		return m;
	}
	@RequestMapping("/clickprod")
	public ModelAndView prod(Map<String, Object> map)
	{
		log.debug("End show product list");
		ModelAndView m=new ModelAndView("/index");
		  List<Product> productList=	productDAO.list();
		  m.addObject("productList", productList);
		  m.addObject("product", product);
		  m.addObject("pro","true");
		  map.put("list", "productList");
		  log.debug("End show product list");
		return m;
	}
	
	@RequestMapping("/createproduct")
	public ModelAndView prod()
	{
		log.debug("show the product details");
		ModelAndView m=new ModelAndView("/Addproduct");
		
		return m;
	}
	
}
