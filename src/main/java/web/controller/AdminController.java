package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

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
    public String editPost(@ModelAttribute("user") User user,
                           HttpServletRequest request,
                           HttpSession session) {

        Set<Role> roles = user.getRole();
        String isAdmin = request.getParameter("admin");
        String isUser = request.getParameter("user");

        if (isAdmin != null) {
            roles.add(roleService.getRole("ADMIN"));
        }
        if (isUser != null) {
            roles.add(roleService.getRole("USER"));
        }
        if (roles.size() == 0) {
            session.setAttribute("status","Не выбрана роль");
            return "redirect:/admin";
        }

        user.setRole(roles);
        userService.editUser(user);
        return "redirect:/admin";
    }

    @GetMapping("delete")
    public String deleteGet(ModelMap map) {
        return "admin/deleteUserPage";
    }

    @PostMapping("delete")
    public String deletePost(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("add")
    public String addGet(ModelMap map){
        return "admin/add";
    }

    @PostMapping("add")
    public String addPost(@ModelAttribute("user") User user,
                          HttpServletRequest request,
                          HttpSession session) throws Exception {

        Set<Role> roles = user.getRole();
        String isAdmin = request.getParameter("admin");
        String isUser = request.getParameter("user");

        if (isAdmin != null) {
            roles.add(roleService.getRole("ADMIN"));
        }
        if (isUser != null) {
            roles.add(roleService.getRole("USER"));
        }
        if (roles.size() == 0) {
            session.setAttribute("status","Не выбрана роль");
            return "redirect:/admin";
        }

        user.setRole(roles);
        if (userService.addUser(user)){
            return "redirect:/admin";
        } else {
            session.setAttribute("status","Такое имя уже есть");
            return "redirect:/admin";
        }
    }
}
