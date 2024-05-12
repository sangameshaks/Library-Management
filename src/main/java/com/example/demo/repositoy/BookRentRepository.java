package com.example.demo.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BookRent;
@Repository
public interface BookRentRepository extends JpaRepository<BookRent, Integer> {

}
