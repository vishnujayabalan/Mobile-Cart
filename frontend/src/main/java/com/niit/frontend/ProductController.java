package com.niit.frontend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.niit.backend.dao.ProductDAO;
import com.niit.backend.model.Product;




@Controller
public class ProductController {
	
	private static final Logger log=LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	
	
	//CURD Operations	
	
	
	@PostMapping("/manage_product_create")
	public ModelAndView createCategory(@RequestParam("id")String id, 
			@RequestParam("name")String name, @RequestParam("categoryid")String categoryid , @RequestParam("supplierid")String supplierid , 
			@RequestParam("price")double price, @RequestParam("quantity")String quantity,@RequestParam("productimages")MultipartFile images)
	{
		log.debug("Start product method");
		product.setId(id);
		product.setName(name);
		product.setCategoryid(categoryid);
		product.setSupplierid(supplierid);
		product.setPrice(price);
		product.setQuantity(quantity);
		productDAO.save(product);
		ModelAndView mv = new ModelAndView("redirect:/clickprod");
		String path="D:\\eclipse\\workspace\\Main\\frontend\\src\\main\\resources\\images\\";
		product.setPimage(images);
		path=path+String.valueOf(product.getId())+".jpg";
		File f=new File(path);
		
	
		MultipartFile filedet=product.getPimage();
		
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  FileOutputStream fos=new FileOutputStream(f);
			  BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				log.debug("Exception Arised"+e);
			}
		}
		else
		{
			log.debug("File is Empty not Uploaded");
			
		}
		
		return mv;
		
	}

	@GetMapping("/manage_product_delete/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") String id)
	{
		log.debug("Start product delete method");
		ModelAndView mv = new ModelAndView("redirect:/clickprod");
		
		productDAO.delete(id);
		log.debug("end product delete method");
		return mv;
		
		
	}
	@RequestMapping("/findProduct")
	public ModelAndView findProduct(@RequestParam("id") String id, Map<String, Object> map)
	{
		log.debug("Start findProduct method");
		Product product=productDAO.getProductByID(id);
		ModelAndView mv=new ModelAndView("/productdetails","command", new Product() );
		mv.addObject("proFound",product);
		mv.addObject("click","true");
		log.debug("end findProduct method");
		return mv;
	}
	
	@PostMapping("/manage_product_edit")
	public ModelAndView editProduct(@RequestParam("id")String id, 
			@RequestParam("name")String name,  @RequestParam("categoryid")String categoryid , @RequestParam("supplierid")String supplierid , 
			@RequestParam("price")double price, @RequestParam("quantity")String quantity )
	{
		log.debug("Start product edit method");
		product.setId(id);
		product.setName(name);
		product.setCategoryid(categoryid);
		product.setSupplierid(supplierid);
		product.setPrice(price);
		product.setQuantity(quantity);
		productDAO.update(product);		
		ModelAndView mv = new ModelAndView("redirect:/clickprod");
		log.debug("end product edit method");
		return mv;
	}
	@RequestMapping("/selProductView")
	
	public ModelAndView viewProduct(Map<String, Object> map)
	{
		log.debug("show productview page");
	String path="D:\\eclipse\\workspace\\Main\\frontend\\src\\main\\resources\\images\\";
		List<Product> prodList=productDAO.list();
		map.put("prList", prodList );
		map.put("path", path);
		ModelAndView mv=new ModelAndView("/index",map);
		mv.addObject("clickpro",true);
		log.debug("end productview page  showmethod");
		return mv;
	}
	
	
}