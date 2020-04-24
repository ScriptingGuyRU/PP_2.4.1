package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Role;
import web.model.Sex;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	private UserService userService;


	@GetMapping("login")
	public String loginGet(ModelMap map) {
		return "login";
	}

	@PostMapping("login")
	public ModelAndView loginPost(HttpSession session,
			@RequestParam String login, String password) {
		ModelAndView mv = new ModelAndView();
		User user = userService.getUserByNameAndPassword(login, password);
		session.setAttribute("user",user);
		if (user.getRole().equals(Role.ADMIN)){
			mv.setViewName("redirect:/admin");
			System.out.println(mv.getViewName());
			return mv;
		}
		mv.setViewName("redirect:/user");
		return mv;
	}

	@PostMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/login";
	}

}