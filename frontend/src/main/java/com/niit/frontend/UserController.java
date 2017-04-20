package com.niit.frontend;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.backend.dao.ProductDAO;
import com.niit.backend.dao.UserDAO;
import com.niit.backend.model.User;
import javax.servlet.http.HttpSession;;
@Controller

public class UserController {

private static final Logger log=LoggerFactory.getLogger(UserController.class);
	@Autowired
	private ProductDAO productDAO;
@Autowired	
private UserDAO userDAO;
@Autowired
private User user;
@Autowired
public HttpSession session;

 @PostMapping("/create_register")
public ModelAndView createRegister(@RequestParam("userid")String id, 
		@RequestParam("name")String name, @RequestParam("email")String email , @RequestParam("pwd")String password, 
		@RequestParam("cpwd")String confirmpassword)
{
	 
	log.debug("start create register method");
	 user.setRole("USER");
	user.setId(id);
	user.setName(name);
	user.setEmail(email);
	user.setPassword(password);
	user.setConfirmpassword(confirmpassword);
	userDAO.saveUser(user);
	log.debug("save user details in database");
	ModelAndView m=new ModelAndView("redirect:/regis");
	m.addObject("regiser","true");
	log.debug("end create register method");
	return m;
}
 @PostMapping("/validation")
 public ModelAndView valid(@RequestParam("userid") String id,@RequestParam("pwd") String password)
 {
	 String a="ADMIN";
	 log.debug("start validation method");
if((userDAO.getUserById(id))!=null)
{
	User user=userDAO.getUserById(id);
if(user.getPassword().equalsIgnoreCase(password))
	{
		if(userDAO.getRole(id).equalsIgnoreCase(a))
		{
		ModelAndView m=new ModelAndView("/index");
		session.setAttribute("thisadmin",true);
		m.addObject("admin","true");
		 log.debug("admin login");
		return m;
		}else
		{
			
		ModelAndView m=new ModelAndView("/index");
		String path="D:\\eclipse\\workspace\\Main\\frontend\\src\\main\\resources\\images\\";
		m.addObject("thisuser","true");
		 session.setAttribute("User_id", id);
		 session.setAttribute("user",true);
		 m.addObject("product","true");
		 m.addObject("prList",productDAO.list());
		 m.addObject("path",path);
		 log.debug("user login");
	    return m;
		}
	}else
	{
		ModelAndView m=new ModelAndView("/index");
		m.addObject("passwordfailure","true");
		m.addObject("clicklogin","true");
		m.addObject("msg","Incorrect password!");
		log.debug("login failure due to wrong password");
		return m;
	}
}else
	{
	ModelAndView mv=new ModelAndView("/index");
	mv.addObject("loginfailure","true");
	mv.addObject("clicklogin","true");
    mv.addObject("msg","invalid password or id!");		
		return mv;
	}
 }
}
 




	
 


