package com.example.demo.service;

import com.example.demo.entity.LibraryUsers;
import com.example.demo.repositoy.LibraryUsersRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LibraryUsersServiceImplementation implements LibraryUsersService {
	 @Autowired
	   LibraryUsersRepository repo;

	   public String addUser(LibraryUsers user) {
	      this.repo.save(user);
	      return "user added successfully";
	   }

	   public LibraryUsersRepository getUser(String name) {
	      return null;
	   }

	   public List<LibraryUsers> getAllUser() {
	      return repo.findAll();
	   }

	   public boolean checkEmail(String email) {
	      return repo.existsByEmail(email);
	   }

	   public boolean validate(String email, String password) {
	      if (this.repo.existsByEmail(email)) {
	         LibraryUsers u = repo.getByEmail(email);
	         String dbpassword = u.getPassword();
	         return password.equals(dbpassword);
	      } else {
	         return false;
	      }
	   }

	   public String deleteUser(int userId) {
	      Optional<LibraryUsers> user = repo.findById(userId);
	      if (user.isPresent()) {
	         repo.delete((LibraryUsers)user.get());
	      }

	      return "user deleted";
	   }
}
