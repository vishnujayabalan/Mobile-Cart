package com.niit.frontend;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.SupplierDAO;

import com.niit.backend.model.Supplier;

@Controller
public class SupplierController {
	
	private static final Logger log=LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Supplier supplier;
	
	
	
	//CURD Operations	
	
	
	@PostMapping("/manage_Supplier_create")
	public ModelAndView createSupplier(@RequestParam("id")String id, 
			@RequestParam("name")String name, @RequestParam("address")String address)
	{
		log.debug("start supplier create method");
		supplier.setId(id);
		supplier.setName(name);
		supplier.setAddress(address);
		supplierDAO.save(supplier);
		ModelAndView mv = new ModelAndView("redirect:/clicksup");
		log.debug("end supplier create method");
		return mv;
		
	}
	@GetMapping("/manage_Supplier_delete/{id}")
	public ModelAndView deleteSupplier(@PathVariable("id") String id)
	{
		log.debug("start supplier delete method");
		ModelAndView mv = new ModelAndView("redirect:/clicksup");
		
		supplierDAO.delete(id);
		log.debug("end supplier delete method");
		return mv;
		
		
	}
	@RequestMapping("/findSupplier")
	public ModelAndView findSupplier(@RequestParam("id") String id, Map<String, Object> map)
	{
		log.debug("start supplier find method");
		Supplier supplier=supplierDAO.getSupplierByID(id);
		ModelAndView mv=new ModelAndView("/supplierdetails","command", new Supplier() );
		mv.addObject("supFound",supplier );
		mv.addObject("click","true");
		log.debug("end supplier find method");
		return mv;
	}
	@PostMapping("manage_Supplier_edit")
	public ModelAndView editSupplier(@RequestParam("id")String id, 
			@RequestParam("name")String name, @RequestParam("address")String address ) {
		log.debug("start supplier edit method");
		supplier.setId(id);
		supplier.setName(name);
		supplier.setAddress(address);
		 supplierDAO.update(supplier);
		 ModelAndView m=new ModelAndView("redirect:/clicksup");
		 log.debug("end supplier edit method");
		return m;
	}
}