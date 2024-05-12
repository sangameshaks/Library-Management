package com.example.demo.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.LibraryUsers;
@Repository
public interface LibraryUsersRepository extends JpaRepository<LibraryUsers , Integer> {
	 boolean existsByEmail(String email);

	   LibraryUsers getByEmail(String email);

	   LibraryUsers getByUserId(int userId);
}
