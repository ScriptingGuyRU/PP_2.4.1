package web.controller;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String adminMainPage(ModelMap modelMap){
        List<User> list = userService.getAllUsers();
        modelMap.addAttribute("usersList",list);
        return "admin/adminMainPage";
    }

    @GetMapping("/edit")
    public String editGet(ModelMap map) {
        return "admin/editUserPage";
    }

    @PostMapping("edit")
    public ModelAndView editPost(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "sex") Sex sex,
            @RequestParam(value = "role") Role role) {

        ModelAndView mv = new ModelAndView();

        if (id < 0 || id == null || name == null || password == null || sex == null || role == null) {
            mv.setStatus(HttpStatus.BAD_REQUEST);
            mv.setViewName("redirect:/admin");
            return mv;
        }

        userService.editUser(new User(id,name,password,sex,Role.ADMIN));
        mv.setViewName("redirect:/admin");
        return mv;
    }

    @GetMapping("delete")
    public String deleteGet(ModelMap map) {
        return "admin/deleteUserPage";
    }

    @PostMapping("delete")
    public String deletePost(@RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        userService.delete(user);
        return "redirect:/admin";
    }

    @GetMapping("add")
    public String addGet(ModelMap map){
        return "admin/add";
    }

    @PostMapping("add")
    public ModelAndView addPost(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "sex") Sex sex,
            @RequestParam(value = "role") Role role) {
        ModelAndView mv = new ModelAndView();
        userService.addUser(new User(name,password,sex,role));
        mv.setViewName("redirect:/admin");
        return mv;
    }
}
