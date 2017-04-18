package com.niit.backend;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.dao.MycartDAO;
import com.niit.backend.model.Mycart;


public class MycartTest {
	
	@Autowired
	private static Mycart mycart;
	
	@Autowired
	private static MycartDAO cartDAO;
	
	
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
		mycart = (Mycart) context.getBean("mycart");
		
		cartDAO = (MycartDAO) context.getBean("cartDAO");
		
	}
	long d=System.currentTimeMillis();
	Date today = new Date(d);
	@Test
	public void create()
	{
	
	 List <Mycart> list=cartDAO.getallcartdetails("ert");
	for(Mycart mycart:list) {
		System.out.println(mycart.getId());
		System.out.println(mycart.getPrice());
		System.out.println(mycart.getProductname());
		System.out.println(mycart.getQuantity());
		System.out.println(mycart.getUser_id());
		System.out.println(mycart.getStatus());
	
		
	}
	
	}
		
	}

