package com.niit.frontend;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.niit.backend.dao.ProductDAO;
import com.niit.backend.dao.MycartDAO;
import com.niit.backend.model.Mycart;
import com.niit.backend.model.Product;


import org.springframework.stereotype.Controller;
@Controller
public class CartController {
	private static final Logger log=LoggerFactory.getLogger(CartController.class);
	@Autowired
	private MycartDAO cartDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Mycart mycart;
	@Autowired
	private HttpSession session;

long d=System.currentTimeMillis();
Date today = new Date(d);
 
@RequestMapping("mycart")
public ModelAndView showmycart()
{
	log.debug("start add cart method");
	String id=(String) session.getAttribute("User_id");
	List<Mycart> list= cartDAO.getallcartdetails(id);
	ModelAndView mv= new ModelAndView("/index");
	mv.addObject("showcartlist",list);
	mv.addObject("mycart",mycart);
	mv.addObject("clickcart",true);
	return mv;
}



@GetMapping("/addtocart/{id}")
public ModelAndView savecart(@PathVariable ("id") String productid )
{	
	log.debug("start add cart method");
	String id=(String) session.getAttribute("User_id");


	if(id!=null)
	{
		
		Product product = productDAO.getProductByID(productid);
		mycart.setId(ThreadLocalRandom.current().nextInt(100, 1000000 + 1));
		mycart.setDate_added(today);
		mycart.setPrice(product.getPrice());
		mycart.setProductname(product.getName());
		mycart.setQuantity(1);
		mycart.setStatus("N");
		mycart.setUser_id(id);
		cartDAO.save(mycart);
		ModelAndView mv= new ModelAndView("redirect:/mycart");
		log.debug("end add cart method");
			return mv;
	}else
	
	{
	ModelAndView mv=new ModelAndView("redirect:/clicklog");
	log.debug("redirect user to login page b");
	return mv;
	}
}


@GetMapping("/deletecart/{id}")
public ModelAndView deletecart(@PathVariable("id")int id)
{
	log.debug("start deletecart method");
	Mycart mycart= cartDAO.getbyid(id);
	cartDAO.delete(mycart);
	ModelAndView mv=new ModelAndView("redirect:/mycart");
	log.debug("end deletecart method");
	return mv;
	
}

@RequestMapping("/increasequantity/{id}")
public ModelAndView increasequantity(@PathVariable("id")int id)
{
	log.debug("start increasequantity  method");
	Mycart mycart=cartDAO.getbyid(id);
	int qty=mycart.getQuantity();
	double rate=((mycart.getPrice()/mycart.getQuantity())+mycart.getPrice());
	 int q=qty+1;
	mycart.setQuantity(q);
	mycart.setPrice(rate);
	cartDAO.update(mycart);
	ModelAndView mv=new ModelAndView("redirect:/mycart");
	log.debug(" end increasequantity  method");
	return mv;
}

@RequestMapping("/decreasequantity/{id}")
public ModelAndView decreasequantity(@PathVariable ("id")int id)
{
	
	log.debug("start decreasequantity  method");
	Mycart mycart=cartDAO.getbyid(id);
	int qty=mycart.getQuantity();
	double rate=(mycart.getPrice()-(mycart.getPrice()/mycart.getQuantity()));
	if(qty<=1)
	{
		 ModelAndView mv1= new ModelAndView("redirect:/mycart");
		 log.debug("end decreasequantity  method");
		return mv1;
	}
	qty=qty-1;
	mycart.setQuantity(qty);
	mycart.setPrice(rate);
	cartDAO.update(mycart);
	ModelAndView mv=new ModelAndView("redirect:/mycart");
	log.debug("end decreasequantity  method");
	return mv;
}
@RequestMapping("/clickout")
public ModelAndView logout()
{
	log.debug("start logout  method");
	ModelAndView mv=new ModelAndView("/index");
	mv.addObject("home","true");
	session.removeAttribute("User_id");
	session.removeAttribute("user");
	session.removeAttribute("user");
	session.removeAttribute("thisadmin");
	mv.addObject("slide",true);
	log.debug("end logout  method");
	return mv;
}

}
	

