package com.niit.admin;
import java.util.List;
import java.util.Map;
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
	ModelAndView mv=new ModelAndView("/index");
	List<Category> categoryList=	categoryDAO.list();
	  mv.addObject("categoryList", categoryList);
	  mv.addObject("category", category);
	  map.put("list", "categoryList");
	return mv;
	}
	@RequestMapping("/clicksup")
	public ModelAndView supply(Map<String, Object> map)
	{
		ModelAndView m=new ModelAndView("/index");
		 List<Supplier> supplierList=	supplierDAO.list();
		  m.addObject("supplierList", supplierList);
		  m.addObject("supplier", supplier);
		  map.put("list", "supplierList");
		return m;
	}
	@RequestMapping("/clickprod")
	public ModelAndView prod(Map<String, Object> map)
	{
		ModelAndView m=new ModelAndView("/index");
		  List<Product> productList=	productDAO.list();
		  m.addObject("productList", productList);
		  m.addObject("product", product);
		  map.put("list", "productList");
		return m;
	}
	
	@RequestMapping("/createproduct")
	public ModelAndView prod()
	{
		ModelAndView m=new ModelAndView("/Addproduct");
		
		return m;
	}
	
}
