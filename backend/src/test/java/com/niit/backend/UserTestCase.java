package com.niit.backend;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.backend.dao.UserDAO;
import com.niit.backend.model.User;
public class UserTestCase {
	@Autowired
	public static User user;
	
	
	@Autowired
	public static UserDAO userDAO;
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
		
		user= (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
	
	

}
