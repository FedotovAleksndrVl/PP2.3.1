package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {

        //model.addAttribute("users", users);
        return "users"; // Возвращаем имя HTML файла без расширения
    }

    @GetMapping("/new")
    public String newUsers(Model model) {
        User user = new User();
        user.setName("qda");
        user.setLastName("ada");
        user.setAge((byte)25);
        userService.saveUser(user);
        return "edituser"; // Возвращаем имя HTML файла без расширения
    }

    /*
    @GetMapping("/news")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "edituser"; // Возвращаем имя HTML файла без расширения
    }

    @PostMapping
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edituser"; // Возвращаем имя HTML файла без расширения
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }*/
}