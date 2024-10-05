package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.Comparator;
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
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users.html";
    }

    @GetMapping("/edit")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        if(user.getId() != null) {
            model.addAttribute("user", userService.getUserById(user.getId()));
        }
        return "edit.html";
    }

    @PostMapping("/edit")
    public String save(@ModelAttribute("user") User user) {
        if (user.getId() == null) {
            userService.saveUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/users";
    }

    @PostMapping("/del")
    public String deleteUser(@ModelAttribute("user") User user) {
            userService.removeUserById(user.getId());
        return "redirect:/users";
    }


/*
    @GetMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user, Model model) {

        return "edit.html";
    }


    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }


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