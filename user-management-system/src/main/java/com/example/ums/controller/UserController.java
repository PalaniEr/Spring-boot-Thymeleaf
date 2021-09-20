package com.example.ums.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ums.entity.User;
import com.example.ums.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}
	
	@GetMapping("/users/new")
	public String createUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "create_user";
	}
	
	@PostMapping("/users")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/users/edit/{id}")
	public String editUserForm(@PathVariable Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit_user";
	}
	

	@PostMapping("/users/{id}")
	public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {
		
		User existingUser = userService.getUserById(id);
		user.setId(existingUser.getId());
		userService.updateUser(user);
		
		return "redirect:/users";
	}
	
	@GetMapping("/users/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/users";
	}
}
