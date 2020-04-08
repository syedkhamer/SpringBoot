package syed.khamer.myfirstwebappde;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import syed.khamer.myfirstwebappde.service.Loginservice;

@Controller
@SessionAttributes("name")
public class LoginController {
    
	@Autowired
	Todoservice todoservice;
	
	@Autowired
	Loginservice service;
	
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    	
    }
	
	@RequestMapping(value="/list-todo", method= RequestMethod.GET)
	public String Showtodo(ModelMap model) {
		String sesName = (String)model.get("name");
		model.put("todos", todoservice.retrieveTodos(sesName));
		return "list-todo";
	}
	
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String showwelcome(ModelMap model) {
		
		
		
	      model.put("name", "syed khamer");
		//model.put("password", password);
		return "welcome";
	}
	
	@RequestMapping(value="/add-todo", method= RequestMethod.GET)
	public String Showaddtodo(ModelMap model) {
		
		model.addAttribute("todo", new Todo(0,(String)model.get("name"), "Default Description", new Date(), false ));
		return "add-todo";
	}
	
	@RequestMapping(value="/add-todo", method= RequestMethod.POST)
	public String addtodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			
			return "add-todo";
		}
		todoservice.addTodo((String)model.get("name"), todo.getDesc(), new Date(), false);
		return "redirect:/list-todo";
	}
	
	@RequestMapping(value="/delete-todo", method= RequestMethod.GET)
	public String Dleteaddtodo(@RequestParam int id) {
		
		todoservice.deleteTodo(id);
		//todoservice.addTodo((String)model.get("name"), desc, new Date(), false);
		return "redirect:/list-todo";
	}
	
	@RequestMapping(value="/update-todo", method= RequestMethod.GET)
	public String updatetodo(@RequestParam int id, ModelMap model) {
		
		Todo todo =todoservice.retrieveTodos(id);
	     model.put("todo", todo);
		return "add-todo";
	}
	
	@RequestMapping(value="/update-todo", method= RequestMethod.POST)
	public String updatetodoPost(@Valid Todo todo, BindingResult result, ModelMap model) {
		
      if(result.hasErrors()) {
			
			return "add-todo";
		}
        todo.setUser((String)model.get("name"));
		todoservice.updateTodo(todo);
		return "redirect:/list-todo";
	}
}
