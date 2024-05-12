package com.example.demo.service;

import com.example.demo.entity.LibraryansList;
import com.example.demo.repositoy.LibraryiansListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LibraryiansListServiceImplementation implements LibraryiansListService {
	 @Autowired
	   LibraryiansListRepository repo;

	   public boolean checkuserName(String name) {
	      return this.repo.existsByuserName(name);
	   }

	   public boolean validate1(String name, int password) {
	      if (this.repo.existsByuserName(name)) {
	         LibraryansList u = this.repo.getByuserName(name);
	         int dbpassword1 = u.getPassword();
	         return password == dbpassword1;
	      } else {
	         return false;
	      }
	   }
}
