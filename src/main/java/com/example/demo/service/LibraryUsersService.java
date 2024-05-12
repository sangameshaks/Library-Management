package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LibraryUsers;
import com.example.demo.repositoy.LibraryUsersRepository;

public interface LibraryUsersService {
	 String addUser(LibraryUsers user);

	   LibraryUsersRepository getUser(String userName);

	   List<LibraryUsers> getAllUser();

	   String deleteUser(int userId);

	   boolean checkEmail(String email);

	   boolean validate(String email, String password);
}
