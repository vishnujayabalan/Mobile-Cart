package com.niit.frontend;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.niit.backend.dao.CategoryDAO;
import com.niit.backend.model.Category;

@Controller
public class CategoryController {
	private static final Logger log=LoggerFactory.getLogger(CategoryController.class);

	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;

	@PostMapping("/manage_category_create")
	public ModelAndView createCategory(@RequestParam("id")String id, 
			@RequestParam("name")String name, @RequestParam("description")String description)
	{
		log.debug("start category create method");
		category.setid(id);
		category.setName(name);
		category.setDescription(description);
		categoryDAO.save(category);
		ModelAndView mv = new ModelAndView("redirect:/clickcate");
		log.debug("End category create method");
		return mv;
		
	}
	@GetMapping("/manage_category_delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") String id)
	{
		log.debug("start category delete method");
		ModelAndView mv = new ModelAndView("redirect:/clickcate");
		categoryDAO.delete(id);
		log.debug("end category delete method");
		return mv;	
	}
	@RequestMapping("/findCategory")
	public ModelAndView findCategory(@RequestParam("id") String id, Map<String, Object> map)
	{
		log.debug("find category byusing id ");
		Category category=categoryDAO.getCategoryByID(id);
		ModelAndView mv=new ModelAndView("/categorydetails","command", new Category() );
		mv.addObject("click","true");
		mv.addObject("cgFound", category);
		log.debug(" end find category byusing id method ");
		return mv;
	}
	@PostMapping("manage_category_edit")
	public ModelAndView editCategory(@RequestParam("id")String id, 
			@RequestParam("name")String name, @RequestParam("description")String description ) {
		log.debug(" start category edit method");
		category.setid(id);
		category.setName(name);
		category.setDescription(description);
		 categoryDAO.update(category);
		 ModelAndView mv=new ModelAndView("redirect:/clickcate");
		 log.debug(" End category edit method");
		return mv;
	}
}