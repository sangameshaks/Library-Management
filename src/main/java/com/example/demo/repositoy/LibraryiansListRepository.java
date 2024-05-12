package com.example.demo.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LibraryansList;
@Repository 
public interface LibraryiansListRepository extends JpaRepository<LibraryansList, Integer> {
	 boolean existsByuserName(String name);

	   LibraryansList getByuserName(String name);
}
