package com.niit.frontend;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController 
{
	@Autowired
	private HttpSession session;
	@RequestMapping("/")
	public ModelAndView show()
	{
		System.out.println("Inside show()");
		ModelAndView mv=new ModelAndView("/index");
		mv.addObject("showPage", "indexPage");
	      mv.addObject("home",true);
	      mv.addObject("slide",true);
		return mv;
	}
	@RequestMapping("/admin")
	public ModelAndView admin()
	{
		System.out.println("Inside ()");
		ModelAndView mv=new ModelAndView("/index");
		mv.addObject("admin","true");
		return mv;
	}
	@RequestMapping("/click")
	public ModelAndView home()
	{
		
		ModelAndView mv=new ModelAndView("/index");
		mv.addObject("home",true);
		session.removeAttribute("User_id");
		session.removeAttribute("click");
		session.removeAttribute("user");
		mv.addObject("slide",true);
		return mv;
	}
	
	@RequestMapping("/clicklog")
	public ModelAndView log()
	{
		System.out.println("Inside log ()");
		ModelAndView mv=new ModelAndView("/index");
		mv.addObject("clicklogin","true");
		mv.addObject("home",true);
		return mv;
	}
	@RequestMapping("/regis")
	public ModelAndView register()
	{
		System.out.println("Inside ()");
		ModelAndView mv=new ModelAndView("/index");
		mv.addObject("clickreg","true");
		mv.addObject("home",true);
		return mv;
	}
	
}