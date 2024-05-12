package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
	
	 @GetMapping({"/"})
	   public String Homepage() {
	      return "LibraryManagement";
	   }

	   @GetMapping({"/LibraryUsers"})
	   public String LibraryUsers() {
	      return "LibraryUsers";
	   }

	   @GetMapping({"/BookRegister"})
	   public String bookRegister() {
	      return "BookRegister";
	   }

	   @GetMapping({"/FirstPage"})
	   public String FirstPage() {
	      return "FirstPage";
	   }

	   @GetMapping({"/BookManagement"})
	   public String BookManagement() {
	      return "BookManagement";
	   }

	   @GetMapping({"/UserManagement"})
	   public String UserManagement() {
	      return "UserManagement";
	   }

	   @GetMapping({"/LibraryianLogin"})
	   public String LibraryianLogin() {
	      return "LibraryianLogin";
	   }

	   @GetMapping({"/UserLogin"})
	   public String UserLogin() {
	      return "UserLogin";
	   }

	   @GetMapping({"/UserFirstPage"})
	   public String UserFirstPage() {
	      return "UserFirstPage";
	   }

	   @GetMapping({"/BookRent"})
	   public String BookRent() {
	      return "BookRent";
	   }

	   @GetMapping({"/ReturnBook"})
	   public String ReturnBook() {
	      return "ReturnBook";
	   }

	   @GetMapping({"EditUser"})
	   public String EditUser() {
	      return "/EditUser";
	   }
}
